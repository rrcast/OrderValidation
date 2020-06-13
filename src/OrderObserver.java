import java.util.List;

public class OrderObserver implements Observer {
    private Boolean shopper;

    public Boolean getShopper() {
        return shopper;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public Boolean getPartner() {
        return partner;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    private Integer cookingTime;
    private Boolean partner;
    private String lat;
    private String lng;
    private Subject subject;


    public OrderObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update(Boolean shopper, Integer cookingTime, Boolean partner, String lat, String lng) {
        this.shopper = shopper;
        this.cookingTime = cookingTime;
        this.partner = partner;
        this.lat = lat;
        this.lng = lng;
        validate();
    }

    private void validate() {
        if (isValid()) {
            System.out.println("Puede asignarse");

        } else {
            System.out.println("No puede asignarse en esta iteracion");
        }

    }

    //Se suma a differentCounter 1 por cada condicion a evaluar, y se suma 1 a currentCounter por cada condicion evaluada que se cumpla
//Si el numero de condiciones evaluadas que se cumplieron es igual al total de condiciones, significa que no puede asignarse en esta iteracion
    private boolean isValid() {
        int currentCounter = 0;
        int differentCounter = 0;

        for (Order orObElement : Constants.ORDERLIST) {


            if (orObElement.getShopper() != null) {
                differentCounter++;
                if (this.getShopper() == orObElement.getShopper()) {
                    currentCounter++;
                }
            }
            if (orObElement.getCookingTime() != null) {
                differentCounter++;
                if (this.getCookingTime() == orObElement.getCookingTime()) {
                    currentCounter++;
                }
            }
            if (orObElement.getPartner() != null) {
                differentCounter++;
                if (this.getPartner() == orObElement.getPartner()) {
                    currentCounter++;
                }

            }
            if (orObElement.getLat() != null) {
                if (!orObElement.getLat().equals("empty")) {
                    differentCounter++;
                    if (this.getLat() != null) {
                        if (this.getLat().equals(orObElement.getLat())) {
                            currentCounter++;
                        }
                    }
                    if (this.getLat() == null && orObElement.getLat() == null) {
                        currentCounter++;
                    }

                }
            }

            //aqui debi haber usado optional para los casos de null
            if (orObElement.getLng() != null) {

                if (!orObElement.getLng().equals("empty")) {
                    differentCounter++;
                    if (this.getLng() != null && orObElement.getLng() != null) {
                        if (this.getLng().equals(orObElement.getLng())) {
                            currentCounter++;
                        }
                    }
                    if (this.getLng() == null && orObElement.getLng() == null) {
                        currentCounter++;
                    }

                }
            }


//System.out.println("Valor de current " + currentCounter);
            //          System.out.println("Valor de Differet " + differentCounter);

            if (currentCounter == differentCounter && currentCounter != 0) {
                return false;

            }
            currentCounter = 0;
            differentCounter = 0;
        }

        return true;

    }
}


/*
Documentacion:
1- Una order con el atributo shopper=true y el atributo cooking_time=0 no puede asignarse
2- Una order con el atributo partner=true y el atributo cooking_time=0 no puede asignarse
3- Una order con el atributo lat=null y/o el atributo lng=null no puede asignarse
 */