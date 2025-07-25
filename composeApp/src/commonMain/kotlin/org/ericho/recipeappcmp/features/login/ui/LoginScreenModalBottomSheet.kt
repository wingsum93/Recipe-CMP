package org.ericho.recipeappcmp.features.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.ericho.recipeappcmp.features.common.ui.components.ErrorContent
import org.ericho.recipeappcmp.features.common.ui.components.LoginButton
import org.ericho.recipeappcmp.features.common.ui.components.LoginButtonState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import recipeapp_cmp.composeapp.generated.resources.Res
import recipeapp_cmp.composeapp.generated.resources.app_name
import recipeapp_cmp.composeapp.generated.resources.recipe_app_logo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenModalBottomSheet(
    loginViewModel: LoginViewModel,
    showBottomSheet: Boolean,
    onClose: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    val bottomSheetState =
        rememberModalBottomSheetState(skipPartiallyExpanded = true, confirmValueChange = {
            false
        })

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var clearInputFields = {
        email = ""
        password = ""
    }
    val focusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()
    val onCloseIconClick = {
        scope.launch {
            clearInputFields()
            bottomSheetState.hide()
        }.invokeOnCompletion {
            if (!bottomSheetState.isVisible) {
                onClose()
            }
            focusManager.clearFocus()
        }
    }

    val loginState by loginViewModel.loginState.collectAsState()

    if (showBottomSheet) {

        ModalBottomSheet(
            containerColor = MaterialTheme.colorScheme.background,
            dragHandle = {},
            onDismissRequest = {
                onClose()
                clearInputFields()
                focusManager.clearFocus()
            },
            sheetState = bottomSheetState,
            properties = ModalBottomSheetProperties(
                shouldDismissOnBackPress = true
            )
        ) {

            Column(
                modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //Heading
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start,
                        text = stringResource(Res.string.app_name),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Icon(
                        modifier = Modifier.clickable {
                            onCloseIconClick()
                        },
                        contentDescription = "Close",
                        imageVector = Icons.Outlined.Close,
                        tint = MaterialTheme.colorScheme.onBackground
                    )

                }

                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {

                    //Image or logo
                    Image(
                        painter = painterResource(Res.drawable.recipe_app_logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(120.dp).align(Alignment.CenterHorizontally),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    //Email Input

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                            focusedLabelColor = MaterialTheme.colorScheme.primaryContainer,
                            cursorColor = MaterialTheme.colorScheme.primaryContainer,
                            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        ),
                        value = email,
                        onValueChange = {
                            if (loginState is LoginState.Error) loginViewModel.resetState()
                            email = it
                        },
                        label = {
                            Text("Email")
                        },
                        singleLine = true, // ✅ 限制為單行
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next // ✅ 設定鍵盤動作為 Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                // ✅ 當使用者按下 "Next" 時的行為，例如跳到下一個輸入框
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        ),
                        isError = if (password.isEmpty()) false else email.isBlank(),
                        supportingText = {
                            if (email.isBlank()) Text("Email is required")
                        }
                    )


                    Spacer(modifier = Modifier.height(16.dp))

                    var passwordVisible by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                            focusedLabelColor = MaterialTheme.colorScheme.primaryContainer,
                            cursorColor = MaterialTheme.colorScheme.primaryContainer,
                            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        ),
                        value = password,
                        onValueChange = {
                            if (loginState is LoginState.Error) loginViewModel.resetState()
                            password = it
                        },
                        label = {
                            Text("Password")
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val image =
                                if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(image, contentDescription = null)
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password, // ✅ 密碼鍵盤類型
                            imeAction = ImeAction.Done // ✅ IME Action = Enter / Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                // ✅ 當使用者按下 Done / Enter 的時候
                                focusManager.clearFocus()
                                // 你可以在這裡觸發登入或驗證邏輯
                                loginViewModel.login(email, password)
                            }
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    var loginBtnState by remember(loginState) {
                        when (loginState) {
                            is LoginState.Loading -> mutableStateOf(LoginButtonState.LOADING)
                            is LoginState.Error -> mutableStateOf(LoginButtonState.ERROR)
                            is LoginState.Success -> mutableStateOf(LoginButtonState.SUCCESS)
                            else -> mutableStateOf(LoginButtonState.NORMAL)
                        }
                    }
                    when (
                        loginState
                    ) {
                        is LoginState.Loading -> {
                        }

                        is LoginState.Error -> {
                            ErrorContent(text = (loginState as LoginState.Error).message)
                        }

                        is LoginState.Success -> {
                            LaunchedEffect(Unit) {
                                delay(500) // 顯示成功動畫或提示
                                onCloseIconClick()
                                onLoginSuccess()
                            }
                        }

                        else -> Unit
                    }


                    //Button
                    LoginButton(
                        modifier = Modifier.fillMaxWidth().height(45.dp),
                        state = loginBtnState,
                        onClick = {
                            loginViewModel.login(email, password)
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                }
            }

        }
    }


}