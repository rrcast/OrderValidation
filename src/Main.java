public class Main {

    public static void main(String[] args) {


        Order o = new Order();
        OrderObserver orOb = new OrderObserver(o);
        o.setShopper(true);
        o.setCookingTime(100);
        o.setPartner(true);
        o.setLng("44W");
        o.setLat("44N");
        o.setCookingTime(1);
        o.setLat(null);


        //SI se requiere agregar una nueva restriccion solo se debe de poner la siguiente linea con los valores deseados, para el caso de lng y lat se debe poner "empty" si no se desea evaluar
        // Constants.ORDERLIST.add(new Order(null, null , null, "empty", null));

    }
}

/*
3- Dada una lista de restricciones, se debe validar que una orden pueda ser validada cada vez que ocurre un cambio en la misma.
Si la orden pasa las validaciones entonces puede ser asignada a un rappitendero, de lo contrario queda excluida para la iteracion en curso.
Crear una estructura tomando en cuenta que pueden haber X restricciones que se puedan aplicar y debe seguir los principios SOLID.

Documentacion:
1- Una order con el atributo shopper=true y el atributo cooking_time=0 no puede asignarse
2- Una order con el atributo partner=true y el atributo cooking_time=0 no puede asignarse

3- Una order con el atributo lat=null y/o el atributo lng=null no puede asignarse

Ejemplo:
Order:
shopper=true
cooking_time=0
partner=true
lat=null
lng=null


is_valid = Validate(Order)
if is_valid:
print('puede asignarse')
else:
print('no puede asignarse en esta iteracion')
 */
