package com.marcosconforti.espacioallegro.login.data

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import org.junit.Before
import org.junit.Test

class AuthServiceTest{

    @MockK
    private lateinit var firebaseAuth:FirebaseAuth

    private lateinit var firebaseUser:FirebaseUser

    private lateinit var authService: AuthService


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        authService = AuthService(firebaseAuth)
        firebaseUser = mockk()
    }

    @Test
    fun `login success should return FirebaseUser`() = runBlocking {
        val email = "pepito@gmail.com"
        val password = "1234"

        val mockFirebaseUser = mockk<FirebaseUser>()
        val mockAuthResult = mockk<AuthResult> {
            coEvery { user } returns mockFirebaseUser
        }

        coEvery { firebaseAuth.signInWithEmailAndPassword(email, password).await() } returns mockAuthResult

        // When
        val result = authService.login(email, password)

        // Then
        assert(result == mockFirebaseUser)
    }
}