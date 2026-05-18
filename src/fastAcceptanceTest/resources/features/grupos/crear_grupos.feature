# language: es

Característica: Crear Grupo para repartir gastos

  Regla: Los grupos están compuestos por al menos dos miembros

    Escenario: No puedo crear un grupo con un único miembro
      Cuando el usuario intenta crear un grupo indicando un único miembro
      Entonces no debería crear el grupo con un único miembro

  Regla: Los grupos no deben estar compuestos por más de cincos miembros

    Escenario: No puedo crear un grupo con seis miembros
      Cuando el usuario intenta crear un grupo indicando seis miembros
      Entonces no debería crear el grupo con un seis miembros