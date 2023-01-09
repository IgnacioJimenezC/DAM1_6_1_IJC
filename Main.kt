/*Especialización*/
open class personaje(val nombre:String , var puntosVida:UInt, var damage:UInt, var defensa:UInt,var rango:String){

    init {
        require(rango == "Enorme" || rango == "Alto" || rango == "Mediano" || rango == "Pequeño")
        { print("Se requiere un rango apto")}
    }
    open fun atacar():UInt{
        return damage
    }
    fun recibirDanio():UInt{
       puntosVida-=damage-defensa /*Los puntos de vida se vuelven el resultado final de el daño menos la defensa*/
       return puntosVida
    }

    override fun toString(): String {
        return "El personaje se llama $nombre, tiene $puntosVida puntos de vida , hace $damage de daño , tiene " +
                "$defensa de resistencia y tiene un rango $rango"
    }
}


class guerrero(val arma:String, var danio_arma:UInt):personaje
    ("Guts", 100u,100u, 100u,"Pequeño"){
    override fun atacar():UInt{
        return damage+danio_arma
    }
    override fun toString(): String {
        return "El personaje se llama $nombre, tiene $puntosVida puntos de vida , hace ${atacar()} de " +
                "daño , tiene  $defensa de resistencia, su arma es $arma tiene un rango $rango"
    }
    }
class hechizero(val tipo_hechizero:String,val danio_magico:UInt,var capacidad_sanar:UInt):personaje
    ("Sachi",100u,100u,0u,"Enorme"){
    init {
        require(tipo_hechizero == "Sanador" || tipo_hechizero =="Tierra" || tipo_hechizero == "Agua" ||
                tipo_hechizero == "Aire" || tipo_hechizero=="Fuego" || tipo_hechizero=="Todoterreno"){
            println("Escoge un tipo de mago correcto")}
    }

    override fun atacar(): UInt {
        return damage+danio_magico
    }

    override fun toString(): String {
        return "El personaje se llama $nombre, tiene $puntosVida puntos de vida , hace ${atacar()} de daño , tiene " +
                "$defensa de resistencia, tiene un rango $rango y es un hechizero de tipo $tipo_hechizero"
    }
    fun sanar():UInt{
        puntosVida+=capacidad_sanar
        return puntosVida
    }
}
//COMO Q ESTO SE PODÍA HACER
fun main(){
    val Naomi=personaje("Naomi",100u,50u,60u,"Alto")
    val Guts = guerrero("Mandoble",200u)
    val sachi = hechizero("Tierra",80u,60u)
    println(Naomi.toString())
    println(Guts.toString())
    println(sachi.toString())
}