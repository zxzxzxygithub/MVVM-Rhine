package com.qingmei2.sample.ui.main.repos

import androidx.fragment.app.Fragment
import com.qingmei2.sample.common.FabAnimateViewModel
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

const val REPOS_MODULE_TAG = "REPOS_MODULE_TAG"

val reposKodeinModule = Kodein.Module(REPOS_MODULE_TAG) {

    bind<FabAnimateViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        FabAnimateViewModel()
    }

    bind<ReposViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        ReposViewModel.instance(
                activity = context.activity!!,
                repo = instance()
        )
    }

    bind<ILocalReposDataSource>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        LocalReposDataSource()
    }

    bind<IRemoteReposDataSource>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        RemoteReposDataSource(instance())
    }

    bind<ReposDataSource>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        ReposDataSource(instance(), instance())
    }
}