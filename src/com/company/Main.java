package com.company;

public class Main {

    public static void main(String[] args) {
        AdjecencyGraph towns = new AdjecencyGraph();

        Vertex Eskildstrup = new Vertex("Eskildstrup");
        Vertex Haslev =new Vertex("Haslev");
        Vertex Holbaek =new Vertex("Holbæk");
        Vertex Jaergerspris =new Vertex("Jærgerspris");
        Vertex Kalundborg =new Vertex("Kalundborg");
        Vertex Korsoer =new Vertex("Korsør");
        Vertex Koege =new Vertex("Køge");
        Vertex Maribo =new Vertex("Maribo");
        Vertex Naestved =new Vertex("Næstved");
        Vertex Ringsted =new Vertex("Ringsted");
        Vertex Slagelse =new Vertex("Slagelse");
        Vertex NykoebingF =new Vertex("Nykøbing F");
        Vertex Vordingborg =new Vertex("Vordingborg");
        Vertex Roskilde =new Vertex("Roskilde");
        Vertex Soroe =new Vertex("Sorø");
        Vertex Nakskov =new Vertex("Nakskov");

        towns.addVertex(Eskildstrup);
        towns.addEdge(Eskildstrup, Maribo, 28);
        towns.addEdge(Eskildstrup, NykoebingF, 13);
        towns.addEdge(Eskildstrup, Vordingborg, 24);

        towns.addVertex(Haslev);
        towns.addEdge(Haslev, Korsoer, 60);
        towns.addEdge(Haslev, Koege, 24);
        towns.addEdge(Haslev, Naestved, 25);
        towns.addEdge(Haslev, Ringsted, 19);
        towns.addEdge(Haslev, Roskilde, 47);
        towns.addEdge(Haslev, Slagelse, 48);
        towns.addEdge(Haslev, Soroe, 34);
        towns.addEdge(Haslev, Vordingborg, 40);

        towns.addVertex(Holbaek);
        towns.addEdge(Holbaek, Jaergerspris, 34);
        towns.addEdge(Holbaek, Kalundborg, 44);
        towns.addEdge(Holbaek, Korsoer, 66);
        towns.addEdge(Holbaek, Ringsted, 36);
        towns.addEdge(Holbaek, Roskilde, 32);
        towns.addEdge(Holbaek, Slagelse, 46);
        towns.addEdge(Holbaek, Soroe, 34);

        towns.addVertex(Jaergerspris);
        towns.addEdge(Jaergerspris, Korsoer, 95);
        towns.addEdge(Jaergerspris, Koege, 58);
        towns.addEdge(Jaergerspris, Ringsted, 56);
        towns.addEdge(Jaergerspris, Roskilde, 33);
        towns.addEdge(Jaergerspris, Slagelse, 74);
        towns.addEdge(Jaergerspris, Soroe, 63);

        towns.addVertex(Kalundborg);
        towns.addEdge(Kalundborg, Ringsted, 62);
        towns.addEdge(Kalundborg, Roskilde, 70);
        towns.addEdge(Kalundborg, Slagelse, 39);
        towns.addEdge(Kalundborg, Soroe, 51);

        towns.addVertex(Korsoer);
        towns.addEdge(Korsoer, Naestved, 45);
        towns.addEdge(Korsoer, Slagelse, 20);

        towns.addVertex(Koege);
        towns.addEdge(Koege, Naestved, 45);
        towns.addEdge(Koege, Ringsted, 28);
        towns.addEdge(Koege, Roskilde, 25);
        towns.addEdge(Koege, Vordingborg, 60);

        towns.addVertex(Maribo);
        towns.addEdge(Maribo, Nakskov, 27);
        towns.addEdge(Maribo, NykoebingF, 26);

        towns.addVertex(Naestved);
        towns.addEdge(Naestved, Roskilde, 57);
        towns.addEdge(Naestved, Ringsted, 26);
        towns.addEdge(Naestved, Slagelse, 37);
        towns.addEdge(Naestved, Soroe, 32);
        towns.addEdge(Naestved, Vordingborg, 28);

        towns.addVertex(Ringsted);
        towns.addEdge(Ringsted, Roskilde, 31);
        towns.addEdge(Ringsted, Soroe, 15);
        towns.addEdge(Ringsted, Vordingborg, 58);

        towns.addVertex(Slagelse);
        towns.addEdge(Slagelse, Soroe, 14);

        //skal resten have edges også? eller er det ligegyldigt?
            // det er ligegyldigt da det ikke gør noget hvis de samme Edges kommer igen.
        towns.addVertex(NykoebingF);
        towns.addVertex(Vordingborg);
        towns.addVertex(Roskilde);
        towns.addVertex(Soroe);
        towns.addVertex(Nakskov);

        towns.makeUndirected();

        towns.MSTprims();

    }
}
