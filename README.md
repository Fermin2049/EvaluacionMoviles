# Evaluación Moviles

Este repositorio contiene el código fuente de una aplicación Android de evaluación de productos móviles. La aplicación permite gestionar una lista de productos, visualizar detalles y llevar a cabo acciones como agregar, listar y eliminar productos.

## Características

- **Lista de productos:** Visualiza una lista de productos con detalles como nombre, precio y descripción.
- **Agregar productos:** Permite agregar nuevos productos a la lista.
- **Interfaz de usuario intuitiva:** Basada en `Fragments` para una mejor navegación.
- **Almacenamiento local:** La aplicación utiliza almacenamiento local para persistir la información de los productos.

## Estructura del proyecto

- `app/src/main/java/com/fermin2049/evalucionmoviles/`: Contiene el código fuente principal de la aplicación.
  - **Activities**: 
    - `IntroActivity.java`: Actividad de introducción.
    - `MainActivity.java`: Actividad principal que contiene la navegación entre fragments.
  - **Modelos**:
    - `Product.java`: Clase que representa un producto.
  - **Adapters**:
    - `ProductAdapter.java`: Adaptador para manejar la visualización de productos en una lista.
  - **Fragments**:
    - `CarryFragment.java`: Fragmento para gestionar el transporte de productos.
    - `LeaveFragment.java`: Fragmento que permite dejar productos.
    - `ListFragment.java`: Muestra la lista de productos.
    - `DetailProductFragment.java`: Detalles del producto seleccionado.

- `app/src/main/res/`: Contiene los recursos del proyecto.
  - **Layouts**: Archivos XML que definen la interfaz de usuario, como `activity_main.xml`, `fragment_list.xml`, etc.
  - **Drawables**: Imágenes y gráficos utilizados en la aplicación.
  - **Values**: Definiciones de estilos, cadenas de texto, colores, etc.

## Tecnologías utilizadas

- **Lenguaje:** Java
- **Framework:** Android SDK
- **Patrones de diseño:** MVVM (Model-View-ViewModel) para desacoplar la lógica de la UI.
- **Herramientas de compilación:** Gradle con Kotlin DSL

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/Fermin2049/EvaluacionMoviles.git
