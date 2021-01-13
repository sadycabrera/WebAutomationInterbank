WEB AUTOMATION LOGIN: Se usa el patrón Page Object Model juntamente con Page Factory

Resumen: Ejecuta de forma automatizada el login de un web app en diferentes navegadores

Para ejecutar, primero agregar la dependencia el archivo pom.xml:


A) SI QUIERES EJECUTAR EN LOS 3 NAVEGADORES

1. Ir al archivo testngAllBrowser.xml
2. Ejecutarlo

B) SI QUIERES INDICARLE EL NAVEGADOR COMO PARA PARAMETRO 

1. Ir a testngByBrowser.xml 
2. Indicar el browser en cual se quiere ejecutar: chrome, edge o firefox
3. Ejecutar el test desde el archivo testngByBrowser.xml  