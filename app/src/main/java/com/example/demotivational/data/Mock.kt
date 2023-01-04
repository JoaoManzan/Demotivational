package com.example.demotivational.data

import com.example.demotivational.infra.Constants
import kotlin.random.Random

private data class Phrase(val content: String, val category: Int, val language: String)

class Mock {

    private val all = Constants.MenuFilter.ALL
    private val sad = Constants.MenuFilter.SAD
    private val rainy = Constants.MenuFilter.RAINY

    private val langEn = Constants.Language.ENGLISH
    private val langPt = Constants.Language.PORTUGUESE
    private val langFr = Constants.Language.FRENCH

    private val multiPhrasesList = listOf(
        Phrase("Não sabendo que era impossível, foi lá e provou.", sad, langPt),
        Phrase("Você não é derrotado quando perde, você é derrotado quando tenta!",
            sad, langPt),
        Phrase("Quando está mais escuro, vemos mais estrelas!**", sad, langPt),
        Phrase("Insanidade é fazer alguma coisa e esperar sucesso.", sad, langPt),
        Phrase("Não pare quando estiver cansado, nem tente.", sad, langPt),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?**",
            sad, langPt),
        Phrase("As vezes a gente perde, as vezes a gente não ganha.", sad, langPt),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.**", rainy, langPt),
        Phrase("Você tem uma chance de falhar em todas as chances que você aproveita.",
            rainy, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.**", rainy, langPt),
        Phrase("Enquanto estivermos comprometidos, haverá derrota!", rainy, langPt),
        Phrase("Se você sabe onde quer ir, em qualquer caminho da pra se perder.",
            rainy, langPt),
        Phrase("Se você acredita, da pra se decepcionar.", rainy, langPt),
        Phrase("Riscos devem ser corridos, porque sempre da pra ficar pior!",
            rainy, langPt),
        Phrase("As vezes a gente perde, as vezes a gente não ganha.", rainy, langPt),



        Phrase("Not knowing it was impossible, he went there and prove it.", sad, langEn),
        Phrase(
        "You are not defeated when you lose, you are defeated when you try!",
            sad,langEn),//here
        Phrase("When it's darker, we see more stars!", sad, langEn),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            sad, langEn),
        Phrase("Don't stop when you're tired, stop when you're done.", sad, langEn),
        Phrase("What can you do now that has the biggest impact on your success?",
            sad, langEn),
        Phrase("The best way to predict the future is to invent it.", rainy, langEn),
        Phrase("You lose every chance you don't take.", rainy, langEn),
        Phrase("Failure is the spice that flavors success.", rainy, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", rainy, langEn),
        Phrase("If you don't know where you want to go, any way will do.", rainy, langEn),
        Phrase("If you believe, it makes all the difference.", rainy, langEn),
        Phrase(
        "Risks must be taken, because the greatest danger is not risking anything!",
            rainy,langEn),



        Phrase("Ne sachant pas que c'était impossible, il y est allé et a prouvé.",
            sad, langFr),
        Phrase(
        "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu essaies!",
            sad, langFr),//here
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", sad, langFr),
        Phrase(
        "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            sad, langFr),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.",
            sad, langFr),
        Phrase(
        "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            sad, langFr),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", rainy, langFr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", rainy, langFr),
        Phrase("L'échec est l'épice qui parfume le succès.", rainy, langFr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", rainy, langFr),
        Phrase(
        "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            rainy, langFr),
        Phrase("Si vous croyez, cela fait toute la différence.", rainy, langFr),
        Phrase(
        "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            rainy, langFr)

        )

    fun randomizePhrases(value: Int, language: String): String{

        var langFilter = language.lowercase()
        if (language !in listOf(langEn, langPt, langFr)) {
            langFilter = langEn
        }

        val filtered = multiPhrasesList.filter { (it.category == value || value == all)
                && (it.language == langFilter)}

        val rand = Random.nextInt(filtered.size)

        return filtered[rand].content
    }
}