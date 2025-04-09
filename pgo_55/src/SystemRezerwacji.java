import java.util.ArrayList;

public class SystemRezerwacji {
    private ArrayList<Wydarzenie> listaWydarzen = new ArrayList<>();
    private ArrayList<Klient> listaKlientow = new ArrayList<>();

    public void dodajWydarzenie(Wydarzenie wydarzenie) {
        listaWydarzen.add(wydarzenie);
    }
    public void dodajWydarzenie(String nazwa,double cena, String data, String miejsce) {
        Wydarzenie wydarzenie = new Wydarzenie(nazwa, cena, data, miejsce);
        listaWydarzen.add(wydarzenie);
    }
    public void dodajKlienta(Klient klient) {
        listaKlientow.add(klient);
    }
    public void dodajKlienta(String imie, String nazwisko, String email){
        Klient klient = new Klient(imie, nazwisko, email);
        listaKlientow.add(klient);
    }
    public void  dokonajRezerwacji(Klient klient, Wydarzenie wydarzenie) {
        this.listaWydarzen.add(wydarzenie);
        this.listaKlientow.add(klient);
        klient.dodajRezerwacje(wydarzenie);
        wydarzenie.zarezerwujMiejsce();
    }
    public Wydarzenie znajdzWydarzenie(String nazwa){
        for(Wydarzenie wydarzenie : listaWydarzen){
            if(wydarzenie.getNazwa().equals(nazwa)){
                return wydarzenie;
            }
        }
        return null;
    }
    public Klient znajdzKlienta(String nazwisko){
        for(Klient klient : listaKlientow){
            if(klient.getNazwisko().equals(nazwisko)){
                return klient;
            }
        }
        return null;
    }
    public void zmienCeneWydarzenia(String nazwa, double nowaCena){
        Wydarzenie wydarzenie = znajdzWydarzenie(nazwa);
        if(wydarzenie != null){
            wydarzenie.setCena(nowaCena);
        }else{
            throw new IllegalArgumentException("Wydarzenie nie istnieje");
        }
    }
}
