# Dealer's [WIP]

## Aplicación para compras

Proyecto MVP para traer una lista de productos desde una API y mostrarlos en categorías.
Dichas categorías serán seleccionables desde las opciones visibles en el menú deslizante.

El producto destacado se mostrará siempre primero, en la parte superior de la vista principal de la
vista inicial de la aplicación, seguido de una lista deslizante en orden jerárquico descendiente,
ubicada inmediatamente debajo.

La barra superior de la aplicación alojará al título, logo de la marca, y un botón de acceso al
carro de compras.

Un click sobre cualquier vista de producto traerá una vista detallada del mismo.
Todas las vistas contienen un botón para agregar el producto al carro.

- Actualmente implementados:
    * Pantalla principal
    * Menú deslizante
    * Barra de título:
        - Botón de menú deslizante
          * ~~Botón de carro de compras~~
    * Vista de productos:
        - Destacado
        - General
        - Detalle
        - ~~`onClickListener` para agregado de producto al carro de compras~~
    * ~~RecyclerView para listado general~~
    * ~~Vista de carro (con RecyclerView de elementos agregados)~~
    * ~~Business logic para cálculo de prioridad de exhibición~~
    * ~~Tests unitarios~~
