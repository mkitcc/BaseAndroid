package org.itsman.baseandroid.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.itsman.baseandroid.R

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                init(Navigation.findNavController(this))
            }
        }
    }
}

@Composable
private fun init(findNavController: NavController) {
    Image(painter = painterResource(id = R.drawable.asdf),
        contentDescription = null,
        modifier = Modifier.clickable { findNavController.navigateUp() }
    )
}
