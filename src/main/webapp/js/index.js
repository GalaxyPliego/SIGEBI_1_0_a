validacion = (form) => {
    //Validación del correo institucional
    let correoInstitucional = form.correoInstitucional;
    if (correoInstitucional.value == "" || correoInstitucional.value == "Correo Institucional"){
        alert("Ingrresa tu correo correo electrónico");
        correoInstitucional.focus();
        correoInstitucional.select();

        //se retorna falso debido a que los datos no son válidos, de caso contrario se enviaría el formulario con datos vaciós
        return(false);
    }

    //Validación de la contraseña
    let contrasenia = form.contrasenia;
    if (contrasenia.value == "" || contrasenia.value < 3) {
        alert("considera que tu contraseña debe ser mayor a 3 caracteres");
        contrasenia.focus();
        contrasenia.select();

        //se retorna falso debido a que los datos no son válidos, de caso contrario se enviaría el formulario con datos vaciós
        return false;
    }
    return true;
}