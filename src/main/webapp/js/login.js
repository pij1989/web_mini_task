const EMAIL = 'email';
const PASSWORD = 'password';
const LOGIN_FORM = 'loginForm';
const REG_EX_EMAIL = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;
const REG_EX_PASSWORD = /[a-zA-Z0-9@#$%!]{8,40}/;
let email = document.getElementById(EMAIL);
let password = document.getElementById(PASSWORD);
let loginForm = document.getElementById(LOGIN_FORM);

const isValidPassword = (password) => {
    return REG_EX_PASSWORD.test(password);
};

const isValidEmail = (email) => {
    return REG_EX_EMAIL.test(email);
};


const handleChange = (event) => {
    let value = event.target.value;
    let name = event.target.name;
    console.log(name);
    console.log(value);
};

email.addEventListener('change', handleChange);
password.addEventListener('change', handleChange);
loginForm.addEventListener('submit', (event) => {
    event.preventDefault();
    event.stopPropagation();
    console.log("Submit... ")
} );
