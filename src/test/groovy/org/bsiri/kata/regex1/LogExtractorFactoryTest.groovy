package org.bsiri.kata.regex1

import spock.lang.Specification

class LogExtractorFactoryTest extends Specification {

    // ********************* Level 1 ***********************************************

    def "should extract from the logs every lines about a given class"(){
        given:
            def lines = load("dungeon.log")

        when:
        def extractor = LogExtractorFactory.createClassFilterExtractor("org.bsiri.randomcode.heroquest.Orc")
        def result = extractor.extract(lines)

        then:
            result == [
                    "[DEBUG] 10:24:30    == org.bsiri.randomcode.heroquest.Orc : failed to kill a rat !",
                    "[DEBUG] 15:28:30    == org.bsiri.randomcode.heroquest.Orc : failed again to kill a rat !",
                    "[INFO]  18:40:20    == org.bsiri.randomcode.heroquest.Orc : decided to eat the rat instead"
            ]

    }

    def "should marshal a logfile and return the classnames"(){
        given:
            def lines = load("dungeon.log")

        when:
            def extractor = LogExtractorFactory.createClassnameExtractor()
            def result = extractor.extract(lines)

        then:
        result == [
                "org.bsiri.randomcode.heroquest.Orc",
                "org.bsiri.randomcode.heroquest.Dungeon",
                "org.bsiri.randomcode.heroquest.Boss",
                "org.bsiri.randomcode.heroquest.Orc",
                "org.bsiri.randomcode.heroquest.Boss",
                "org.bsiri.randomcode.heroquest.Bat",
                "org.bsiri.randomcode.heroquest.Orc",
                "org.bsiri.randomcode.heroquest.Dungeon",
                "org.bsiri.randomcode.heroquest.Dungeon"
        ]
    }


    def "should print the Boss' workday highlights"(){

        given:
            def lines = load("dungeon.log")

        when:
        def extractor = LogExtractorFactory.createMonsterWorkdayExtractor("org.bsiri.randomcode.heroquest.Boss")
        def result = extractor.extract(lines)

        then:
        result == [
                "11:59:59 : lunch time, I'm off",
                "15:50:20 : back from lunch"
        ]

    }

    def "should log everything that happened in the afternoon except the INFO level"(){
        given:
        def lines = load("dungeon.log")

        when:
        def extractor = LogExtractorFactory.createAfternoonNoInfoExtractor()
        def result = extractor.extract(lines)

        then:
        result == [
                "[DEBUG] 15:28:30    == org.bsiri.randomcode.heroquest.Orc : failed again to kill a rat !",
                "[DEBUG] 15:50:20    == org.bsiri.randomcode.heroquest.Boss : back from lunch",
                "[ERROR] 19:81:61    == org.bsiri.randomcode.heroquest.Dungeon : impossible hour !"
        ]

    }

    def "should swap the seconds, minutes and hours from the logs"(){
        given:
        def lines = load("dungeon.log")

        when:
        def extractor = LogExtractorFactory.createTimeTwisterExtractor()
        def result = extractor.extract(lines)

        then:
            result == [
                    "[DEBUG] 30:24:10    == org.bsiri.randomcode.heroquest.Orc : failed to kill a rat !",
                    "[ERROR] 56:00:11    == org.bsiri.randomcode.heroquest.Dungeon : created room with negative coordinates",
                    "[INFO]  59:59:11    == org.bsiri.randomcode.heroquest.Boss : lunch time, I'm off",
                    "[DEBUG] 30:28:15    == org.bsiri.randomcode.heroquest.Orc : failed again to kill a rat !",
                    "[DEBUG] 20:50:15    == org.bsiri.randomcode.heroquest.Boss : back from lunch",
                    "[INFO]  38:10:16    == org.bsiri.randomcode.heroquest.Bat : morphed to human form and gone fighting crime in Gotham",
                    "[INFO]  20:40:18    == org.bsiri.randomcode.heroquest.Orc : decided to eat the rat instead",
                    "[INFO]  00:41:18    == org.bsiri.randomcode.heroquest.Dungeon : awared 1po to the orc.bsiri.randomcode.heroquest.Orc",
                    "[ERROR] 61:81:19    == org.bsiri.randomcode.heroquest.Dungeon : impossible hour !"
            ]
    }


    // ************************************ Level 2 *****************************************************


    def "should list the simple classname of all the monsters that fought today"(){
        
    }



    def load(name){
        new File(this.class.classLoader.getResource(name).toURI()).readLines()
    }

}
