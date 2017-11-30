# Sistema de Gestion de Proyectos
Proyecto del cursos de BD2

## Integrantes
* Guadalupe Palpán
* Luis Chávez
* Jose Carlos Bustamante
* Raúl Cáceres

## Especificaciones
* **Plataforma:** NetBeans 8.1 
* **Gestor de dependencias:** Apache Maven

## Instalación de Apache Maven
**IMPORTANTE**: Debes tener instalado Apache Maven
**Guia de instalación**: http://gustavopeiretti.com/instalar-maven-en-windows/

## Instalar dependencias de Maven en repositorio local

1. Ejecutar el cmd y escribir

```
cd ${projectBase}\SGPY\lib
```

2. Ejecutar:
```
mvn install:install-file -Dfile=DateChooser.jar -DgroupId=com.guis -DartifactId=DateChooser -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=edisoncorSX.jar -DgroupId=com.guis -DartifactId=edisoncorSX -Dversion=1.0 -Dpackaging=jar
```
