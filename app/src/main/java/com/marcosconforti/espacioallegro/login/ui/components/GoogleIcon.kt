package com.marcosconforti.espacioallegro.login.ui.components

import android.app.Activity
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.marcosconforti.espacioallegro.R
import com.marcosconforti.espacioallegro.login.ui.LoginViewModel

@Composable
fun GoogleIcon(viewModel: LoginViewModel, navigateFromGoogleToMenu: () -> Unit) {
    val context = LocalContext.current
    var image: Uri? = null
    val googleLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {
                    val account = task.getResult(ApiException::class.java)!!
                    //image = task.result.photoUrl
                    viewModel.loginWithGoogle(account.idToken!!) {
                        navigateFromGoogleToMenu()
                    }
                } catch (e: ApiException) {
                    Toast.makeText(context, "Ha ocurrido un error ${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    IconButton(
        onClick = {
            viewModel.onGoogleLoginSelected {
                googleLauncher.launch(it.signInIntent)
            }
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = stringResource(id = R.string.login_with_google)
        )
    }

}