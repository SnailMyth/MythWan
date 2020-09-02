package com.myth.ft_home.ui.project

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myth.ft_home.model.ProjectTabItem
import com.myth.lib_base.base.BaseContext
import com.myth.lib_net.model.NetResult
import kotlinx.coroutines.launch

class ProjectViewModel(private val navigationRepo: ProjectRepository) : ViewModel() {

    private val tabDataLiveData = MutableLiveData<MutableList<ProjectTabItem>>()

    fun getTabData(): MutableLiveData<MutableList<ProjectTabItem>> {
        viewModelScope.launch {
            val tabData = navigationRepo.getTabData()
            if (tabData is NetResult.Success) {
                tabDataLiveData.postValue(tabData.data)
            } else if (tabData is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    tabData.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return tabDataLiveData
    }


}