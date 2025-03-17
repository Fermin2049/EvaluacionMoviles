# 📱 EvaluacionMoviles

**EvaluacionMoviles** es una aplicación móvil desarrollada en **Android con Java**, utilizando **MVVM (Model-View-ViewModel)** para la gestión de productos. La app permite visualizar una lista de productos, ver detalles individuales y administrar información mediante una interfaz intuitiva.

---

## 📌 Características

- 🛒 **Lista de productos**: Visualización de productos con su información detallada.
- 🔍 **Detalle de productos**: Información ampliada sobre cada producto.
- 📂 **Arquitectura MVVM**: Implementación modular y escalable.
- 🎨 **Interfaz optimizada**: Uso de XML para layouts responsivos.
- 🚀 **Compatibilidad con múltiples dispositivos**: Diseño adaptado para distintas resoluciones de pantalla.

---

## 🛠️ Tecnologías utilizadas

- **Java (Android)**: Lógica principal de la aplicación.
- **MVVM (Model-View-ViewModel)**: Separación de responsabilidades para mejor mantenibilidad.
- **Android Jetpack**: Uso de ViewModels y LiveData.
- **RecyclerView**: Listado dinámico de productos.
- **Gradle**: Gestión de dependencias.

---

## 📁 Estructura del Proyecto

```bash
EvaluacionMoviles/
│── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml         # Configuración principal de la app
│   │   ├── java/com/fermin2049/evaluacionmoviles/
│   │   │   ├── IntroActivity.java      # Pantalla de bienvenida
│   │   │   ├── MainActivity.java       # Actividad principal
│   │   │   ├── model/
│   │   │   │   ├── Product.java        # Modelo de producto
│   │   │   │   ├── ProductAdapter.java # Adaptador para lista de productos
│   │   │   ├── ui/
│   │   │   │   ├── list/ListFragment.java   # Fragmento para mostrar la lista
│   │   │   │   ├── list/ListViewModel.java  # ViewModel para la lista
│   │   │   │   ├── list/DetailProductFragment.java  # Detalle del producto
│   │   │   │   ├── list/DetailProductViewModel.java # ViewModel del detalle
│   │   ├── res/layout/
│   │   │   ├── activity_main.xml       # Layout de la actividad principal
│   │   │   ├── fragment_list.xml       # Layout para lista de productos
│   │   │   ├── fragment_detail_product.xml # Layout del detalle de producto
│   ├── build.gradle.kts                 # Configuración de dependencias
│── settings.gradle.kts                   # Configuración del proyecto
│── gradle/                               # Archivos de Gradle
```

---

## 🚀 Instalación y Uso

### 1️⃣ Clonar el repositorio

```sh
git clone https://github.com/Fermin2049/EvaluacionMoviles.git
```

### 2️⃣ Abrir en Android Studio

- Importar el proyecto en **Android Studio**.
- Verificar que el **SDK de Android** esté correctamente configurado.

### 3️⃣ Ejecutar la aplicación

- Conectar un **dispositivo físico** o usar un **emulador**.
- Presionar **Run** en **Android Studio**.

---

![image](https://github.com/user-attachments/assets/91237eb8-029e-4be5-b708-67078e71dfb7)
![image](https://github.com/user-attachments/assets/d741266c-897d-41b6-bd83-db159e26ea37)



## 📜 Licencia

Este proyecto es de uso libre bajo la licencia **MIT**.

