package com.ing3.convertisseurnombreenlettre

class NombreEnLettresFrancais {

    // Tableaux pour les conversions
    private val unites = arrayOf("", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf")
    private val dizaines = arrayOf("", "dix", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante-dix", "quatre-vingt", "quatre-vingt-dix")
    private val speciales = arrayOf("dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf")

    // Méthode de conversion
    fun convertir(nombre: Int): String {
        if (nombre == 0) return "zéro" // Cas spécial pour zéro
        if (nombre < 0) return "moins ${convertir(-nombre)}" // Cas des nombres négatifs

        var resultat = ""
        var restant = nombre

        // Conversion des milliers
        if (restant / 1000 > 0) {
            resultat += "${convertir(restant / 1000)} mille "
            restant %= 1000
        }

        // Conversion des centaines
        if (restant / 100 > 0) {
            resultat += if (restant / 100 == 1) "cent " else "${unites[restant / 100]} cent "
            restant %= 100
        }

        // Conversion des dizaines spéciales (10 à 19)
        if (restant in 10..19) {
            resultat += speciales[restant - 10]
        } else {
            // Conversion des dizaines classiques
            if (restant / 10 > 0) {
                resultat += dizaines[restant / 10]
                if (restant % 10 > 0) resultat += "-${unites[restant % 10]}"
            } else {
                // Conversion des unités
                resultat += unites[restant]
            }
        }

        return resultat.trim() // Suppression des espaces inutiles
    }
}
