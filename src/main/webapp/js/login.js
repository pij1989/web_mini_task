const LOGIN_FORM = 'loginForm';
const SUBMIT = 'submit';
const WAS_VALIDATED = 'was-validated';
let loginForm = document.getElementById(LOGIN_FORM);

loginForm.addEventListener(SUBMIT, (event) => {
    event.preventDefault();
    event.stopPropagation();
    loginForm.classList.add(WAS_VALIDATED);
    if (loginForm.checkValidity() === true) {
        HTMLFormElement.prototype.submit.call(loginForm);
        loginForm.classList.remove(WAS_VALIDATED);
    }
});
