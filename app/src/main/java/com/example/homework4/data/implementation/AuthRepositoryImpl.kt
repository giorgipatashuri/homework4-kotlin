import com.example.homework4.data.remote.FirebaseAuthDataSource
import com.example.homework4.domain.model.User
import com.example.homework4.domain.repository.AuthRepository
import javax.inject.Inject
import kotlin.Result

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuthDataSource: FirebaseAuthDataSource
) : AuthRepository {
    override suspend fun signUp(email: String, password: String): Result<User> {
        return try {
            val firebaseUser = firebaseAuthDataSource.signUp(email, password)
            if (firebaseUser != null) {
                Result.success(User(
                    id = firebaseUser.uid,
                    email = firebaseUser.email ?: ""
                ))
            } else {
                Result.failure(Exception("Sign up failed"))
            }
        } catch (e: Exception) {
            Result.failure(Exception(e.localizedMessage ?: "Unknown error"))
        }
    }

    override suspend fun signIn(email: String, password: String): Result<User> {
        return try {
            val firebaseUser = firebaseAuthDataSource.signIn(email, password)
            if (firebaseUser != null) {
                Result.success(User(
                    id = firebaseUser.uid,
                    email = firebaseUser.email ?: ""
                ))
            } else {
                Result.failure(Exception("Sign in failed"))
            }
        } catch (e: Exception) {
            Result.failure(Exception(e.localizedMessage ?: "Unknown error"))
        }
    }

    override suspend fun signOut(): Result<Unit> {
        return try {
            firebaseAuthDataSource.signOut()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(Exception(e.localizedMessage ?: "Sign out failed"))
        }
    }

    override fun getCurrentUser(): User? {
        val firebaseUser = firebaseAuthDataSource.getCurrentUser()
        return firebaseUser?.let {
            User(
                id = it.uid,
                email = it.email ?: ""
            )
        }
    }
}
