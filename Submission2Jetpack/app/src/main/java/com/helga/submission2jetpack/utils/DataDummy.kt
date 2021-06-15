package com.helga.submission2jetpack.utils

import com.helga.submission2jetpack.data.MovieEntity
import com.helga.submission2jetpack.data.TvshowEntity
import com.helga.submission2jetpack.data.source.remote.response.MovieResponse
import com.helga.submission2jetpack.data.source.remote.response.TvshowResponse

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "f1",
                "Alita: Battle Angel",
                "Action, Science, Fiction, Adventure",
                "Robert Rodriguez",
                "2019",
                "Laeta Kalogridis, James Cameron",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "f2",
                "Bohemian Rhapsody",
                "Music, Drama, History",
                "Bryan Singer",
                "2018",
                "Anthony McCarten",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "f3",
                "Cold Pursuit",
                "Action, Crime, Thriller",
                "Hans Petter Moland",
                "2019",
                "Frank Baldwin",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "f4",
                "Creed II",
                "Drama",
                "Steve Caple Jr.",
                "2018",
                "Sylvester Stallone",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "f5",
                "Glass",
                "Thriller, Drama, Science Fiction",
                "M. Night Shyamalan",
                "2019",
                "M. Night Shyamalan",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "f6",
                "How to Train Your Dragon: The Hidden World",
                "Animation, Family, Adventure",
                "Dean DeBlois",
                "2019",
                "Dean DeBlois",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "f7",
                "Avengers: Infinity War",
                "Adventure, Action, Science Fiction",
                "Anthony Russo, Joe Russo",
                "2018",
                "Stephen McFeely, Christopher Markus",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "f8",
                "Mortal Engines",
                "Adventure, Cience Fiction",
                "Christian River",
                "2018",
                "Peter Jackson, Fran Walsh, Philippa Boyens",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "f9",
                "Overlord",
                "Horror, War, Science Fiction",
                "Julius Avery",
                "2018",
                "Billy Ray, Mark L. Smith",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/l76Rgp32z2UxjULApxGXAPpYdAP.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "f10",
                "T-34",
                "War, Action, Drama, History",
                "Alexey Sidorov",
                "2018",
                "Alexey Sidorov",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg"
            )
        )

        return movies
    }

    fun generateDummyTvshow(): List<TvshowEntity> {

        val tvShow = ArrayList<TvshowEntity>()

        tvShow.add(
            TvshowEntity(
                "tv1",
                "Arrow",
                "Crime, Drama, Mystery, Action & Adventure",
                "Greg Berlanti, Marc Guggenheim, Andrew KreisBerg",
                "2012",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"
            )
        )
        tvShow.add(
            TvshowEntity(
                "tv2",
                "Doom Patrol",
                "Sci-Fi & Fantasy, Comedy, Drama",
                "Jeremy Carver",
                "2019",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"
            )
        )
        tvShow.add(
            TvshowEntity(
                "tv3",
                "Family Guy",
                "Animation, Comedy",
                "Seth MacFarlane",
                "1999",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"
            )
        )
        tvShow.add(
            TvshowEntity(
                "tv4",
                "Gotham",
                "Drama, Crime, Sci-Fi & Fantasy",
                "Bruno Heller",
                "2014",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"
            )
        )
        tvShow.add(
            TvshowEntity(
                "tv5",
                "Grey's Anatomy",
                "Drama",
                "Shonda Rhimes",
                "2005",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )
        tvShow.add(
            TvshowEntity(
                "tv6",
                "The Flash",
                "Drama, Sci-Fi & Fantasy",
                "Greg Berlanti, Geoff Johns, Andrew Kreisberg",
                "2014",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )
        tvShow.add(
            TvshowEntity(
                "tv7",
                "NCIS",
                "Crime, Action & Adeventure, Drama",
                "Donald P.Bellisarion, Don McGill",
                "2003",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg"
            )
        )
        tvShow.add(
            TvshowEntity(
                "tv8",
                "Riverdale",
                "Mystery, Drama, Crime",
                "Robert Aguirre-Sacasa",
                "2017",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )
        tvShow.add(
            TvshowEntity(
                "tv9",
                "Supernatural",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "eris Kripke",
                "2005",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
            )
        )
        tvShow.add(
            TvshowEntity(
                "tv10",
                "The Simpsons",
                "Family, Animation, Comedy",
                "Matt Groening",
                "1989",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg"
            )
        )

        return tvShow
    }

    fun generateRemoteMovie(): List<MovieResponse>{
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse("f1",
                "Alita: Battle Angel",
                "Action, Science, Fiction, Adventure",
                "Robert Rodriguez",
                "2019",
                "Laeta Kalogridis, James Cameron",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"))
        movies.add(
            MovieResponse(
                "f2",
                "Bohemian Rhapsody",
                "Music, Drama, History",
                "Bryan Singer",
                "2018",
                "Anthony McCarten",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "f3",
                "Cold Pursuit",
                "Action, Crime, Thriller",
                "Hans Petter Moland",
                "2019",
                "Frank Baldwin",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "f4",
                "Creed II",
                "Drama",
                "Steve Caple Jr.",
                "2018",
                "Sylvester Stallone",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "f5",
                "Glass",
                "Thriller, Drama, Science Fiction",
                "M. Night Shyamalan",
                "2019",
                "M. Night Shyamalan",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "f6",
                "How to Train Your Dragon: The Hidden World",
                "Animation, Family, Adventure",
                "Dean DeBlois",
                "2019",
                "Dean DeBlois",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "f7",
                "Avengers: Infinity War",
                "Adventure, Action, Science Fiction",
                "Anthony Russo, Joe Russo",
                "2018",
                "Stephen McFeely, Christopher Markus",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "f8",
                "Mortal Engines",
                "Adventure, Cience Fiction",
                "Christian River",
                "2018",
                "Peter Jackson, Fran Walsh, Philippa Boyens",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "f9",
                "Overlord",
                "Horror, War, Science Fiction",
                "Julius Avery",
                "2018",
                "Billy Ray, Mark L. Smith",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/l76Rgp32z2UxjULApxGXAPpYdAP.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "f10",
                "T-34",
                "War, Action, Drama, History",
                "Alexey Sidorov",
                "2018",
                "Alexey Sidorov",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg"
            )
        )
        return movies
    }

    fun generateRemoteTvshow(): List<TvshowResponse>{
        val tvShow = ArrayList<TvshowResponse>()

        tvShow.add(
            TvshowResponse(
                "tv1",
                "Arrow",
                "Crime, Drama, Mystery, Action & Adventure",
                "Greg Berlanti, Marc Guggenheim, Andrew KreisBerg",
                "2012",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"
            )
        )
        tvShow.add(
            TvshowResponse(
                "tv2",
                "Doom Patrol",
                "Sci-Fi & Fantasy, Comedy, Drama",
                "Jeremy Carver",
                "2019",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"
            )
        )
        tvShow.add(
            TvshowResponse(
                "tv3",
                "Family Guy",
                "Animation, Comedy",
                "Seth MacFarlane",
                "1999",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"
            )
        )
        tvShow.add(
            TvshowResponse(
                "tv4",
                "Gotham",
                "Drama, Crime, Sci-Fi & Fantasy",
                "Bruno Heller",
                "2014",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"
            )
        )
        tvShow.add(
            TvshowResponse(
                "tv5",
                "Grey's Anatomy",
                "Drama",
                "Shonda Rhimes",
                "2005",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )
        tvShow.add(
            TvshowResponse(
                "tv6",
                "The Flash",
                "Drama, Sci-Fi & Fantasy",
                "Greg Berlanti, Geoff Johns, Andrew Kreisberg",
                "2014",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )
        tvShow.add(
            TvshowResponse(
                "tv7",
                "NCIS",
                "Crime, Action & Adeventure, Drama",
                "Donald P.Bellisarion, Don McGill",
                "2003",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg"
            )
        )
        tvShow.add(
            TvshowResponse(
                "tv8",
                "Riverdale",
                "Mystery, Drama, Crime",
                "Robert Aguirre-Sacasa",
                "2017",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )
        tvShow.add(
            TvshowResponse(
                "tv9",
                "Supernatural",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "eris Kripke",
                "2005",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
            )
        )
        tvShow.add(
            TvshowResponse(
                "tv10",
                "The Simpsons",
                "Family, Animation, Comedy",
                "Matt Groening",
                "1989",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg"
            )
        )

        return tvShow
    }

}