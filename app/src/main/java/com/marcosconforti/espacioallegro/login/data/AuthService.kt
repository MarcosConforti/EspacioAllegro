package com.marcosconforti.espacioallegro.login.data

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.marcosconforti.espacioallegro.R
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class AuthService @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    @ApplicationContext private val context: Context
) {
    val userImageURL: String = ""

    //Login with Email and Password
    suspend fun login(email: String, password: String): FirebaseUser? {
        return suspendCancellableCoroutine { cancellableContinuation ->
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    val user = it.user
                    cancellableContinuation.resume(user)
                }
                .addOnFailureListener {
                    cancellableContinuation.resumeWithException(it)
                }
        }
    }

    //Login with Google

    suspend fun loginWithGoogle(idToken: String): FirebaseUser? {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        return completedRegisterWithCredential(credential)
    }

    private suspend fun completedRegisterWithCredential(credential: AuthCredential): FirebaseUser? {
        return suspendCancellableCoroutine { cancellableContinuation ->
            firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener {
                    cancellableContinuation.resume(it.user)
                }.addOnFailureListener {
                    cancellableContinuation.resumeWithException(it)
                }
        }
    }

    fun getGoogleClient(): GoogleSignInClient {
        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(context, gso)
    }

    //User settings
    private fun getCurrentUser() = firebaseAuth.currentUser

    fun getImageUser() = firebaseAuth.currentUser?.photoUrl

    fun isUserLogged(): Boolean {
        return getCurrentUser() != null
    }

    fun logout() {
        firebaseAuth.signOut()
    }

}

/*private val firebaseAuth = mockk<FirebaseAuth>()

private lateinit var authService: AuthService

@Before
fun init() {
    MockKAnnotations.init(this)
    authService = AuthService(firebaseAuth)
}

@Test
fun `login success should return FirebaseUser`() = runBlocking {
    val email = "pepito@gmail.com"
    val password = "1234"
    val firebaseUser = mockk<FirebaseUser>()
    //Given
    coEvery { authService.login(email, password) } returns firebaseUser
    //When
    val result = authService.login(email, password)
    //Then
    assert(result == firebaseUser)
}*/