# idealista Android challenge

En este proyecto se encuentra la implementación de las funcionalidades requeridas: pantalla de detalles de anuncios, y gestión de anuncios favoritos.


#### Pantalla de detalles

Se recoge la url del anuncio y se realiza una petición para obtener los detalles.
He optado por un diseño simple debido a la poca información que hay que mostrar. Una tarjeta que contiene un slider con las fotografías del anuncio y unos botones que se considerarían las acciones importantes.


#### Gestión de favoritos

Persistencia implementada con Room. Las funcionalidades implementadas para la gestión han sido:
 - Añadir anuncio a favoritos
 - Recoger el listado de todos los anuncios favoritos
 - Comprobar por id que un anuncio se encuentra incluido en la base de datos
 - Eliminar un anuncio de favoritos

La pantalla la he incluido en la misma actividad que el listado principal, por medio de un viewPager2 y un tabLayout, aprovechando que ambos eran dos listados similares.


#### Cambios en el proyecto base

Los cambios que se han realizado en el proyecto base han sido los de sustituir el uso del MVP por el del MVVM con data binding.
Me planteé también la sustitución de los Assembler por una herramienta de inyección de dependencias como Dagger o Koin pero finalmente he decidido dejarlo tal cual debido a que no conozco los motivos para el uso de los Assembler.


#### Otras consideraciones

Los test son algo en lo que aún no me he asentado. He realizado muy pocos y aún los ando aprendiendo, por lo que me ha costado implementarlos en este proyecto y al final han sido casi nulos.
El principal motivo es que suelo trabajar con herramientas como RxJava y el encontrarme con una implementación propia en este proyecto se me ha hecho dificultoso el realizar los tests.