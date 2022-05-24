package com.admiral.demo.features.home.notifications

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral.demo.R
import com.admiral.demo.common.BaseFragment
import com.admiral.demo.databinding.FmtNotificationsActionBinding
import com.admiral.demo.features.main.NavigationViewModel
import com.admiral.uikit.components.notifications.action.ActionNotification
import com.admiral.uikit.components.notifications.action.ActionNotificationCloseType

class ActionNotificationFragment : BaseFragment(R.layout.fmt_notifications_action) {

    private val navigationViewModel: NavigationViewModel by viewModels({ requireParentFragment() })
    private val binding by viewBinding(FmtNotificationsActionBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerToolbar(binding.toolbar, true, navigationViewModel::close)

        binding.btnToast.setOnClickListener {
            ActionNotification.Builder(requireContext(), binding.coordinator)
                .setText(getString(R.string.notifications_action_action_text))
                .setDuration(DURATION)
                .setMargins(bottom = MARGIN)
                .setCloseButtonType(ActionNotificationCloseType.TEXT)
                .setCloseButtonText(getString(R.string.notifications_action_cancel_text))
                .build()
                .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        binding.toolbar.inflateMenu(R.menu.menu_appbar_info, menu, inflater)
    }

    private companion object {
        const val DURATION = 5000
        const val MARGIN = 70
    }
}
