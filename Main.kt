/*Especialización*/
open class personaje(var puntosVida:UInt, var damage:UInt, var defensa:UInt,var rango:String){

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
    open fun texto_ataque():String{
        return "¡Personaje ha hecho $damage puntos de daño!"
    }
    override fun toString(): String {
        return "Tiene $puntosVida puntos de vida , hace $damage de daño , tiene " +
                "$defensa de resistencia y tiene un rango $rango"
    }
}


class guerrero(val nombre:String , val arma:String, var danio_arma:UInt):personaje
    (100u,100u, 100u,"Pequeño"){
    override fun atacar():UInt{
        return damage+danio_arma
    }

    override fun texto_ataque(): String {
        return "$nombre ha metido un espadazo que ha hecho ${atacar()} puntos de daño"
    }
    override fun toString(): String {
        return "El personaje se llama $nombre, tiene $puntosVida puntos de vida , hace ${atacar()} de " +
                "daño , tiene  $defensa de resistencia, su arma es $arma tiene un rango $rango"
    }
}
class hechizero(val nombre:String , val tipo_hechizero:String,val danio_magico:UInt,var capacidad_sanar:UInt):personaje
    (100u,100u,0u,"Enorme"){
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

    override fun texto_ataque(): String {
        return "$nombre usó un gran hechizo e hizo ${atacar()} puntos de daño"
    }
    fun sanar():UInt{
        puntosVida+=capacidad_sanar
        return puntosVida
    }
    fun texto_sanacion():String{
        return "$nombre sanó $capacidad_sanar puntos de vida"
    }
}
//Preguntas
//1-Es una especialización, pues con las dos subclases determino que tipo de personaje son
//2-La superclase es personaje y las subclases son guerrero y hechizero
//3-No hay otro método de aplicarlo
//4-Ayuda bastante más a la hora satisfacer las necesidades que tengamos mientras desarrollamos un programa


