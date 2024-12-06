package com.ing3.convertisseurnombreenlettre
class NombreEnLettresAnglais {
    private val unites = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    private val dizaines = arrayOf("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
    private val speciales = arrayOf("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")

    fun convertir(nombre: Int): String {
        if (nombre == 0) return "zero"
        if (nombre < 0) return "minus ${convertir(-nombre)}"

        var resultat = ""
        var restant = nombre

        if (restant / 1000 > 0) {
            resultat += "${convertir(restant / 1000)} thousand "
            restant %= 1000
        }

        if (restant / 100 > 0) {
            resultat += "${unites[restant / 100]} hundred "
            restant %= 100
        }

        if (restant in 10..19) {
            resultat += speciales[restant - 10]
        } else {
            if (restant / 10 > 0) {
                resultat += dizaines[restant / 10]
                if (restant % 10 > 0) resultat += "-${unites[restant % 10]}"
            } else {
                resultat += unites[restant]
            }
        }

        return resultat.trim()
    }
}
