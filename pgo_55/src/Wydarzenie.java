public class Wydarzenie {
    private String nazwa;
    private String data;
    private String miejsce;
    private int maxLiczbaMiejsc = 100;
    private int dostępneMiejsca = 0;
    private double cena;

    public Wydarzenie(String nazwa, double cena, String data, String miejsce) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.data = data;
        this.miejsce = miejsce;
    }

    public Wydarzenie(String nazwa, double cena, String data) {
        this(nazwa, cena, data, "Warszawa");
    }

    public Wydarzenie(String nazwa, double cena) {
        this(nazwa, cena, "03-04-2025");
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public int getMaxLiczbaMiejsc() {
        return maxLiczbaMiejsc;
    }

    public void setMaxLiczbaMiejsc(int maxLiczbaMiejsc) {
        this.maxLiczbaMiejsc = maxLiczbaMiejsc;
    }

    public int getDostępneMiejsca() {
        return dostępneMiejsca;
    }

    public void setDostępneMiejsca(int dostępneMiejsca) {
        if(dostępneMiejsca > maxLiczbaMiejsc){
            throw new IllegalArgumentException("Dostępnych miejsc nie może być wiecęj niż maksymalnej liczby miejsc");
        }
        if(dostępneMiejsca < 0){
            throw new IllegalArgumentException("Dostępnych miejsc nie może być mniej niż zero");
        }
        this.dostępneMiejsca = dostępneMiejsca;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String toString() {
        return "Nazwa wydarzenia: " + nazwa + " " +
                "Data wydarzenia: " + data + " " +
                "Miejsce wydarzenia: " + miejsce + " " +
                "Maksymalna liczba miejsc: " + maxLiczbaMiejsc + " " +
                "Dostępna ilość miejsc: " + dostępneMiejsca;
    }
    public boolean zarezerwujMiejsce(){
        if(dostępneMiejsca > 0 && dostępneMiejsca <= maxLiczbaMiejsc){
            dostępneMiejsca--;
            return true;
        }else{
            return false;
        }
    }
}
