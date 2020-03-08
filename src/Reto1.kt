
fun main(args: Array<String>) {

    escapar@ while (true) {

        val menu = """
        
        :: Bienvenido a Recipe Maker ::

        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
        
        """.trimIndent()

        println(menu)

        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> hacerReceta()
            2 -> verRecetas()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }

    println("Saliendo ...")
}

fun hacerReceta() {

    escapar@while (true){
        val mensaje_inicial = """
            
            :: Hacer una receta ::
    
            Selecciona por categoría el ingrediente que buscas
            1. Agua
            2. Leche
            3. Carne
            4. Verduras
            5. Frutas
            6. Cereal
            7. Huevos
            8. Aceites
            9. Regresar
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> println("Agua")
            2-> println("Leche")
            3-> println("Carne")
            4-> println("Verduras")
            5-> println("Frutas")
            6-> println("Cereal")
            7-> println("Huevos")
            8-> println("Aceites")
            9 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}

fun verRecetas() {

    escapar@while (true) {
        val mensaje_inicial = """
            
            :: Ver mis recetas ::
    
            1. Regresar
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0
        if (options == 1) {
            break@escapar
        }
    }
}

