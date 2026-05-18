# language: es

Característica: Crear Grupo para repartir gastos

  Regla: Los grupos deben poder cambiar de nombre

    Escenario: Puedo cambiarle el nombre a un grupo
        Dado que tengo un grupo llamado "Amigos"
        Cuando intento cambiarle el nombre por "Familia"
        Entonces el nombre del grupo cambia a "Familia"

    Escenario: No cambiarle el nombre a un grupo y dejarlo en blanco
        Dado que tengo un grupo llamado "Amigos"
        Cuando intento cambiarle el nombre por ""
        Entonces no debería realizar ningún cambio el el nombre
        Entonces el nombre seguirá siendo "Amigos"