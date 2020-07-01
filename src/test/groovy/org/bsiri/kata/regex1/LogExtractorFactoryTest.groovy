package org.bsiri.kata.regex1

import spock.lang.Specification

class LogExtractorFactoryTest extends Specification {

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



    def load(name){
        new File(this.class.classLoader.getResource(name).toURI()).readLines()
    }

}
