import java.util.*;
import java.lang.*;

public class main {

    public static void main(String[] args) {

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] englishLetterFrequency = {"E", "T", "A", "O", "N", "I", "H", "S", "R", "L", "D", "U", "C", "M", "W", "Y", "F", "G", "P", "B", "V", "K", "J", "X", "Q", "Z"," "};
        String[] entschlüsselteBuchstaben = {"O","N","I","H"};
        String[] verschlüsselteBuchstaben = {"Q","A","J","U"};
        String[] sortedLetters = new String[27];
        /*List<String> sortedLetterList = new ArrayList<>();*/
        var chiffrat = "X KGIXM QZPPIG VXFXMUAD  U OZQM GIMZGDIN TGAP MJI KGIXMIQM QZPPIG VXFXMUAD! " +
                "UM WXQ QA TXDMXQMUF, U DIVIG WXDMIN UM MA IDN. U QHIDM IUKJM NXRQ UD HXGUQ, TGXDFI. " +
                "PR CIQM TGUIDNQ, JIDGR XDN QMIVI, WIDM WUMJ PI. WI JXN X CIXZMUTZB JAMIB GAAP UD MJI " +
                "BXMUD SZXGMIG, XDN UM WXQD’M IVID IEHIDQUVI. WI JXN X CXBFADR WUMJ X WADNIGTZB VUIW. " +
                "WI VUQUMIN PXDR TXPAZQ MAZGUQM HBXFIQ. PR TXVAGUMI WXQ MJI BAZVGI, X WIBB-LDAWD PZQIZP. " +
                "U WXQ XBWXRQ UDMIGIQMIN UD XGM, QA MJXM WXQ X QHIFUXB MGIXM TAG PI. MJI PZQIZP UQ QA JZKI, " +
                "RAZ FAZBN QHIDN WIILQ MJIGI. JIDGR KAM MUGIN WXBLUDK XGAZDN MJI PZQIZP XDN QXUN “IDAZKJ! " +
                "U DIIN MA MXLI X CGIXL XDN GIQM.”  WI MAAL BAMQ AT CGIXLQ XDN QXM UD FXTIQ XBADK MJI GUVIG " +
                "QIUDI. MJI TGIDFJ TAAN WI XMI WXQ NIBUFUAZQ. MJI WUDIQ WIGI MXQMR, MAA. QMIVI’Q TXVAGUMI " +
                "HXGM AT MJI VXFXMUAD WXQ MJI JAMIB CGIXLTXQM. JI QXUN JI WAZBN CI JXHHR UT JI FAZBN IXM " +
                "FGAUQQXDMQ BULI MJAQI TAGIVIG. WI JXN QA PZFJ TZD MJXM WI’GI XBGIXNR MXBLUDK XCAZM AZG DIEM " +
                "VXFXMUAD!PR WADNIGTZB TXPUBR  U BUVI UD X JAZQI DIXG MJI PAZDMXUDQ. U JXVI MWA CGAMJIGQ XDN " +
                "ADI QUQMIG, XDN U WXQ CAGD BXQM. PR TXMJIG MIXFJIQ PXMJIPXMUFQ, XDN PR PAMJIG UQ X DZGQI XM " +
                "X CUK JAQHUMXB. PR CGAMJIGQ XGI VIGR QPXGM XDN WAGL JXGN UD QFJAAB. PR QUQMIG UQ X DIGVAZQ " +
                "KUGB, CZM QJI UQ VIGR LUDN. PR KGXDNPAMJIG XBQA BUVIQ WUMJ ZQ. QJI FXPI TGAP UMXBR WJID U " +
                "WXQ MWA RIXGQ ABN. QJI JXQ KGAWD ABN, CZM QJI UQ QMUBB VIGR QMGADK. QJI FAALQ MJI CIQM TAAN!  " +
                "PR TXPUBR UQ VIGR UPHAGMXDM MA PI. WI NA BAMQ AT MJUDKQ MAKIMJIG. PR CGAMJIGQ XDN U BULI MA KA " +
                "AD BADK WXBLQ UD MJI PAZDMXUDQ. PR QUQMIG BULIQ MA FAAL WUMJ PR KGXDNPAMJIG. AD MJI WIILIDNQ " +
                "WI XBB HBXR CAXGN KXPIQ MAKIMJIG. WI BXZKJ XDN XBWXRQ JXVI X KAAN MUPI. U BAVI PR TXPUBR VIGR " +
                "PZFJ.AZG VXFXMUAD  IVIGR RIXG WI KA MA TBAGUNX. WI BULI MA KA MA MJI CIXFJ.  PR TXVAGUMI CIXFJ " +
                "UQ FXBBIN IPIGQAD CIXFJ. UM UQ VIGR BADK, WUMJ QATM QXDN XDN HXBP MGIIQ. UM UQ VIGR CIXZMUTZB. " +
                "U BULI MA PXLI QXDNFXQMBIQ XDN WXMFJ MJI QXUBCAXMQ KA CR. QAPIMUPIQ MJIGI XGI NABHJUDQ XDN " +
                "WJXBIQ UD MJI WXMIG!  IVIGR PAGDUDK WI BAAL TAG QJIBBQ UD MJI QXDN. U TAZDN TUTMIID CUK QJIBBQ " +
                "BXQM RIXG. U HZM MJIP UD X QHIFUXB HBXFI UD PR GAAP. MJUQ RIXG U WXDM MA BIXGD MA QZGT. UM UQ " +
                "JXGN MA QZGT, CZM QA PZFJ TZD! PR QUQMIG UQ X KAAN QZGTIG. QJI QXRQ MJXM QJI FXD MIXFJ PI. " +
                "U JAHI U FXD NA UM!PR NXR  TUGQM, U WXLI ZH. MJID, U KIM NGIQQIN. U WXBL MA QFJAAB. " +
                "U NA DAM GUNI X CULI. U NA DAM GUNI MJI CZQ. U BULI MA KA MA QFJAAB. UM GXUDQ. U NA DAM BULI " +
                "GXUD. U IXM BZDFJ. U IXM X QXDNWUFJ XDN XD XHHBI.  U HBXR AZMQUNI. U BULI MA HBXR. U GIXN X CAAL. " +
                "U BULI MA GIXN CAALQ. U WXBL JAPI. U NA DAM BULI WXBLUDK JAPI. PR PAMJIG FAALQ QAZH TAG NUDDIG. MJI QAZH UQ JAM. MJID, U KA MA CIN. " +
                "U NA DAM BULI MA KA MA CIN. MJI JAZQI  PG. XDN PGQ. QPUMJ JXVI ADI QAD XDN ADI NXZKJMIG. " +
                "MJI QAD'Q DXPI UQ OAJD. MJI NXZKJMIG'Q DXPI UQ QXGXJ.  MJI QPUMJQ BUVI UD X JAZQI. MJIR JXVI X " +
                "BUVUDK GAAP. MJIR WXMFJ MV UD MJI BUVUDK GAAP. MJI TXMJIG FAALQ TAAN UD MJI LUMFJID. MJIR IXM UD MJI NUDUDK " +
                "GAAP. MJI JAZQI JXQ MWA CINGAAPQ. MJIR QBIIH UD MJI CINGAAPQ. MJIR LIIH MJIUG FBAMJIQ UD MJI FBAQIM. MJIGI UQ ADI " +
                "CXMJGAAP. MJIR CGZQJ MJIUG MIIMJ UD MJI CXMJGAAP.  MJI JAZQI JXQ X KXGNID. OAJD XDN QXGXJ " +
                "HBXR UD MJI KXGNID. MJIR JXVI X NAK. OAJD XDN QXGXJ BULI MA HBXR WUMJ MJI NAK. HGIHXGUDK TAAN  OXFL WXQ JZDKGR. JI WXBLIN MA MJI LUMFJID. " +
                "JI KAM AZM QAPI IKKQ. JI MAAL AZM QAPI AUB. JI HBXFIN X QLUBBIM AD MJI QMAVI. " +
                "DIEM, JI MZGDIN AD MJI JIXM. JI HAZGIN MJI AUB UDMA MJI QLUBBIM. JI FGXFLIN MJI IKKQ UDMA X CAWB. JI QMUGGIN MJI IKKQ. " +
                "MJID, JI HAZGIN MJIP UDMA MJI JAM QLUBBIM. JI WXUMIN WJUBI MJI IKKQ FAALIN. MJIR FAALIN TAG MWA " +
                "PUDZMIQ. JI JIXGN MJIP FAALUDK. MJIR HAHHIN UD MJI AUB.  DIEM, OXFL HZM MJI IKKQ AD X HBXMI. JI HBXFIN MJI HBXMI AD MJI NUDUDK GAAP MXCBI. " +
                "OXFL BAVIN BAALUDK XM JUQ IKKQ. MJIR BAALIN HGIMMR AD MJI " +
                "WJUMI HBXMI. JI QXM NAWD UD MJI BXGKI WAANID FJXUG. JI MJAZKJM XCAZM MJI NXR XJIXN. JI XMI MJI IKKQ WUMJ X QHAAD. MJIR WIGI KAAN.  " +
                "JI WXQJIN MJI HBXMI WUMJ NUQJWXQJUDK QAXH. MJID, JI WXQJIN MJI HXD. " +
                "JI KAM X QHADKI NXPH. TUDXBBR, JI WUHIN NAWD MJI MXCBI. DIEM, OXFL WXMFJIN MV. XM QFJAAB  BZFXQ KAIQ MA QFJAAB IVIGR NXR AT MJI WIIL. " +
                "JI JXQ PXDR QZCOIFMQ MA KA MA IXFJ QFJAAB NXR: IDKBUQJ, XGM, QFUIDFI, PXMJIPXMUFQ, " +
                "KRP, XDN JUQMAGR. JUQ PAMJIG HXFLQ X CUK CXFLHXFL TZBB AT CAALQ XDN BZDFJ TAG BZFXQ.  JUQ TUGQM FBXQQ UQ IDKBUQJ, XDN JI BULIQ MJXM MIXFJIG VIGR PZFJ. " +
                "JUQ IDKBUQJ MIXFJIG QXRQ MJXM JI UQ X KAAN HZHUB, WJUFJ BZFXQ LDAWQ " +
                "PIXDQ MJXM QJI MJUDLQ JI UQ X KAAN QMZNIDM.  JUQ DIEM FBXQQ UQ XGM. JI NGXWQ AD HXHIG WUMJ FGXRADQ XDN HIDFUBQ XDN " +
                "QAPIMUPIQ ZQIQ X GZBIG. BZFXQ BULIQ XGM. UM UQ JUQ TXVAGUMI FBXQQ.  JUQ MJUGN FBXQQ UQ QFUIDFI. MJUQ FBXQQ UQ VIGR JXGN TAG BZFXQ MA TUKZGI AZM, " +
                "CZM JI KIMQ MA WAGL WUMJ JUQ FBXQQPXMIQ X BAM, WJUFJ JI BULIQ MA NA. JUQ " +
                "TGUIDN, LRBI, WAGLQ WUMJ BZFXQ UD QFUIDFI FBXQQ, XDN MJIR JXVI TZD.  MJID BZFXQ KIMQ JUQ CGIXL TAG BZDFJ. JI QUMQ WUMJ LRBI WJUBI JI IXMQ. MJI " +
                "HGUDFUHXB, AG MJI JIXNPXQMIG XQ QAPI FXBB JUP, " +
                "BULIQ MA WXBL XGAZDN XDN MXBL MA QMZNIDMQ NZGUDK BZDFJ MA FJIFL MJXM MJIR XGI XBB CIJXVUDK.  MJI DIEM FBXQQ UQ PXMJIPXMUFQ, " +
                "WJUFJ PAQM AT MJI QMZNIDMQ OZQM FXBB PXMJ. LRBI JXQ MGAZCBI KIMMUDK X KAAN KGXNI UD PXMJIPXMUFQ, CZM MJI MIXFJIG" +
                " UQ VIGR DUFI XDN JIBHTZB.  JUQ TAZGMJ FBXQQ UQ KRP. UM UQ OZQM IEIGFUQUDK.  JUQMAGR UQ JUQ BXQM FBXQQ AT MJI NXR. BZFXQ JXQ X " +
                "JXGN MUPI QMXRUDK XWXLI. PXDR BIQQADQ XGI CAGUDK, XDN JI UQ VIGR MUGIN XTMIG NAUDK KRP.\n";

        List<LetterCounter> buchstabenZaehlerListe = new ArrayList<>();
        // Eine Liste mit LetterCountern wird erstellt und der count wird für jeden Buchstaben aus dem Array alphabet auf 0 gesetzt
        for (String letter : alphabet) {
            LetterCounter buchstabe = new LetterCounter(letter);
            System.out.println(buchstabe.getLetter() + " = " + buchstabe.getCount());
            buchstabenZaehlerListe.add(buchstabe);
        }
        List<String> mostFrequentWordsEnglishList = new ArrayList<>();
        List<WordCounter> wörterZählerListe = new ArrayList<>();
        String mostFreuquentWordsEnglish = "A ABOUT ALL ALSO AND AS AT BE BECAUSE BUT BY CAN COME COULD DAY DO EVEN FIND FIRST FOR FROM GET GIVE GO HAVE HE HER HERE HIM HIS HOW IF IN INTO IT ITS JUST KNOW LIKE LOOK MAKE MAN MANY ME MORE MY NEW NO NOT NOW OF ON ONE ONLY OR OTHER OUR OUT PEOPLE SAY SEE SHE SO SOME TAKE TELL THAN THAT THE THEIR THEM THEN THERE THESE THEY THING THINK THIS THOSE TIME TO TWO UP USE VERY WANT WAY WE WELL WHAT WHEN WHICH WHO WILL WITH WOULD YEAR YOU YOUR";
        // Jedes einzelne Wort wird in die Liste mostFrequentWordsEnglishList eingefügt
        Tool.convertStringToList(mostFrequentWordsEnglishList,mostFreuquentWordsEnglish);

        for(String word : mostFreuquentWordsEnglish.split(" ")){
            WordCounter wort = new WordCounter(word);
            wörterZählerListe.add(wort);
        }
        /*for (String readLetter : chiffrat.split("")) {
            Optional<LetterCounter> result = buchstabenZaehlerListe.stream()
                    .filter(counter -> counter.getLetter().equals(readLetter))
                    .findAny();
            if (result.isPresent()) {
                result.get().increaseCount();
            }
        }
        */
        // Das Programm zählt die Buchstaben aus dem chiffrat, mit Hilfe einer Methode und erhöht den count eines LetterCounters um den Wert 1
        Tool.countLetters(buchstabenZaehlerListe,chiffrat);

        // Das Programm gibt den aktuellen count nach dem Zaehlen aus
        System.out.println("");
        System.out.println("Gezählte Buchstaben:");
        for (LetterCounter letterCounter : buchstabenZaehlerListe) {
            System.out.println(letterCounter.getLetter() + " = " + letterCounter.getCount());
        }

        // Das Programm sortiert die Buchstaben nach dem höchsten count
        buchstabenZaehlerListe.sort(LetterCounter.LetCountComparator.reversed());
        System.out.println("");
        System.out.println("Die sortierte Liste:");
        for (LetterCounter r : buchstabenZaehlerListe) {
            System.out.println(r.getLetter() + " = " + r.getCount());
        }

        // Das Programm gibt den Schlüssel zu dem verschlüsselten Text aus
        System.out.println("");
        System.out.println("Der Key für das Chiffrat ist:");
        Tool.GetKey(englishLetterFrequency, sortedLetters, buchstabenZaehlerListe, 0);

        StringBuilder buildChiffrat = new StringBuilder();
        System.out.println();
        System.out.println("Der entschlüsselte Text lautet:");
        /*for (String readLetter : chiffrat.split("")) {
            Optional<LetterCounter> result = buchstabenZaehlerListe.stream()
                    .filter(counter -> counter.getLetter().equals(readLetter))
                    .findAny();
            if (result.isPresent()) {
                int getIndex = Arrays.asList(sortedLetters).indexOf(readLetter);
                //if(getIndex < 3) {
                String newLetter = readLetter.replace(readLetter, englishLetterFrequency[Math.abs(getIndex)]);
                //System.out.print(newLetter);
                buildChiffrat.append(newLetter);
                //}
            }
            else{
                //System.out.print(" ");
                buildChiffrat.append(readLetter);
            }
        }
        */
        // Das Programm iteriert durch den Text, mit Hilfe einer Methode und kann so Buchstabe für Buchstabe durch den Key ersetzt werden
        Tool.changeLetter(3, buchstabenZaehlerListe,sortedLetters,englishLetterFrequency,chiffrat,buildChiffrat);
        String newChiffrat = buildChiffrat.toString();
        System.out.println(newChiffrat);
        Tool.findWayWithMostRecognizedWords(entschlüsselteBuchstaben,4,newChiffrat,mostFrequentWordsEnglishList,englishLetterFrequency,verschlüsselteBuchstaben,buchstabenZaehlerListe,wörterZählerListe,buildChiffrat,verschlüsselteBuchstaben);
        //Debugger (Ich weiss, dass das Programm bis hier hin durchgelaufen ist)
        System.out.println("hallo");
/*
        String[] mostFrequentWordsEnglish = {""};
        Node root = new Node("i", "e");
        Node aktuell = root.addNode("m", "t");
        aktuell = aktuell.addNode("x", "a");
        Tool.convertLetterCounterListToStringList(buchstabenZaehlerListe,sortedLetterList);
        Tool.findKey(aktuell, sortedLetterList, buchstabenZaehlerListe);
        */
    }
}

// Eine Klasse LetterCounter wird erstellt, die die Variablen letter und count besitzt
// Die Klasse ist dazu fähig den count zu erhöhen mit increaseCount und sortiert zu werden mit dem Comparator LetCountComparator
class LetterCounter {
    private final String letter;
    private int count;

    public LetterCounter(String letter){
        this.letter = letter;
        this.count = 0;
    }
    public void increaseCount() {
        this.count += 1;
    }

    public String getLetter() {
        return letter;
    }

    public int getCount() {
        return count;
    }

    //Dient dazu, dass die Liste nach dem Vorkommen der Buchstaben sortiert wird
    public static Comparator<LetterCounter> LetCountComparator = new Comparator<LetterCounter>() {
        @Override
        public int compare(LetterCounter l1, LetterCounter l2) {
            int a = l1.getCount();
            int b = l2.getCount();

            return a-b;
        }
    };
}
class WordCounter{

    private final String word;
    private int count;

    WordCounter(String word) {
        this.word = word;
        this.count = 0;
    }
    public void increaseCount(){
        this.count += 1;
    }

    public String getWord(){
        return word;
    }

    public int getCount(){
        return count;
    }
}
