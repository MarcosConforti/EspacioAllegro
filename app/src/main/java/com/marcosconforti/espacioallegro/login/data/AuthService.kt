package com.marcosconforti.espacioallegro.login.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class AuthService @Inject constructor(private val firebaseAuth: FirebaseAuth) {

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