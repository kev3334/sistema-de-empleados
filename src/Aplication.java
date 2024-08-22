import modelos.Empleado;

import java.util.Arrays;
import java.util.Scanner;

public class Aplication {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Empleado[] empleados = new Empleado[20];
        Empleado[] arrayCopiaEmpleados= Arrays.copyOf(empleados,empleados.length);
        boolean isFiltrado = false;
        empleados[0] = new Empleado("Carlos Perez Gomez", 30, 2500.00, "IT");
        empleados[1] = new Empleado("Ana Rodriguez Sanchez", 25, 2200.00, "Marketing");
        empleados[2] = new Empleado("Luis Garcia Fernandez", 40, 3500.00, "Ventas");
        empleados[3] = new Empleado("Marta Lopez Ramirez", 32, 2800.00, "Finanzas");
        empleados[4] = new Empleado("Pedro Sanchez Morales", 28, 2400.00, "IT");
        empleados[5] = new Empleado("Laura Gomez Martinez", 29, 2300.00, "Recursos Humanos");
        empleados[6] = new Empleado("Jorge Diaz Hernandez", 45, 4000.00, "Ventas");
        empleados[7] = new Empleado("Lucia Fernandez Castillo", 35, 3100.00, "Marketing");
        empleados[8] = new Empleado("Sofia Ramirez Torres", 26, 2700.00, "Finanzas");
        empleados[9] = new Empleado("Roberto Morales Vazquez", 50, 4500.00, "Dirección");
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║       SISTEMA DE GESTIÓN DE EMPLEADOS        ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.println("1. Mostrar el listado de empleados");
            System.out.println("2. Agregar un nuevo empleado");
            System.out.println("3. Filtrar empleados");
            System.out.println("4. Ordenar empleados");
            System.out.println("5. Incrementar salario de un empleado");
            System.out.println("6. Limpiar filtros");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción (1-7): ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    mostrarEmpleados(empleados);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    boolean nombreSinCoincidencia = true;
                    for(Empleado empleado : empleados){
                        if (empleado!=null && empleado.getNombre().equalsIgnoreCase(nombre)) {
                            nombreSinCoincidencia = false;
                            break;
                        }
                    }
                    if(nombreSinCoincidencia){
                        System.out.print("Ingrese la edad del empleado: ");
                        int edad = scanner.nextInt();
                        System.out.print("Ingrese el salario del empleado: ");
                        double salario = scanner.nextDouble();
                        System.out.print("Ingrese el departamento del empleado: ");
                        String departamento = scanner.next();
                        Empleado nuevoEmpleado = new Empleado(nombre,edad,salario,departamento);
                        int indice = Empleado.getCantidadEmpleados()-1;
                        empleados[indice]=nuevoEmpleado;
                        System.out.println("Se agregó un nuevo empleado exitosamente.");
                    }else{
                        System.out.println("El nombre ingresado ya existe. No se puede agregar este empleado");
                    }
                    arrayCopiaEmpleados= Arrays.copyOf(empleados,empleados.length);
                    break;
                case 3:
                    int opcionFiltro;
                    do {
                        System.out.println("Seleccione el atributo por el cual va filtrar: ");
                        System.out.println("1. Nombre");
                        System.out.println("2. Edad");
                        System.out.println("3. Salario");
                        System.out.println("4. Departamento");
                        System.out.print("Ingrese una opción entre 1-4: ");
                        opcionFiltro = scanner.nextInt();
                        System.out.print("Ingrese el valor del filtro: ");
                        scanner.nextLine();
                        switch (opcionFiltro) {
                            case 1:
                                String filtroNombre = scanner.nextLine();
                                empleados = Arrays.copyOf(filtrarEmpleados(empleados,filtroNombre,0,0,null), filtrarEmpleados(empleados,filtroNombre,0,0,null).length);
                                mostrarEmpleados(empleados);
                                break;
                            case 2:
                                int filtroEdad = scanner.nextInt();
                                empleados = Arrays.copyOf(filtrarEmpleados(empleados,null,filtroEdad,0,null), filtrarEmpleados(empleados,null,filtroEdad,0,null).length);
                                mostrarEmpleados(empleados);
                                break;
                            case 3:
                                double filtroSalario = scanner.nextDouble();
                                empleados = Arrays.copyOf(filtrarEmpleados(empleados,null,0,filtroSalario,null), filtrarEmpleados(empleados,null,0,filtroSalario,null).length);
                                mostrarEmpleados(empleados);
                                break;
                            case 4:
                                String filtroDepartamento = scanner.nextLine();
                                empleados = Arrays.copyOf(filtrarEmpleados(empleados,null,0,0,filtroDepartamento), filtrarEmpleados(empleados,null,0,0,filtroDepartamento).length);
                                mostrarEmpleados(empleados);
                                break;
                            default:
                                System.out.println("La opción ingresada no es válida");
                                break;
                        }
                    }while(opcionFiltro<=0 || opcionFiltro>4);
                    isFiltrado = true;
                    break;
                case 4:
                    int opcionOrden;
                    do {
                        System.out.println("Seleccione el atributo por el cual va ordenar: ");
                        System.out.println("1. Nombre");
                        System.out.println("2. Edad");
                        System.out.println("3. Salario");
                        System.out.println("4. Departamento");
                        System.out.print("Ingrese una opción entre 1-4: ");
                        opcionOrden = scanner.nextInt();
                        switch (opcionOrden) {
                            case 1:
                                mostrarEmpleados(ordenarEmpleados(empleados, "nombre"));
                                break;
                            case 2:
                                mostrarEmpleados(ordenarEmpleados(empleados, "edad"));
                                break;
                            case 3:
                                mostrarEmpleados(ordenarEmpleados(empleados, "salario"));
                                break;
                            case 4:
                                mostrarEmpleados(ordenarEmpleados(empleados, "departamento"));
                                break;
                            default:
                                System.out.println("La opción ingresada no es válida");
                                break;
                        }
                    }while(opcionOrden<=0 || opcionOrden>4);
                    break;
                case 5:
                    mostrarEmpleados(empleados);
                    System.out.print("Ingrese el número de orden del empleado que desea agregar su salario: ");
                    int numeroEmpleado = scanner.nextInt();
                    System.out.print("Ingrese el pocentaje entre 1 y 100 % que desea aumentar: ");
                    double porcentaje = scanner.nextDouble();
                    empleados[numeroEmpleado-1]=incrementarSalario(empleados[numeroEmpleado-1],(porcentaje/100));
                    System.out.println("Se actualizó el nuevo salario exitosamente");
                    arrayCopiaEmpleados= Arrays.copyOf(empleados,empleados.length);
                    break;
                case 6:
                    empleados = Arrays.copyOf(arrayCopiaEmpleados,arrayCopiaEmpleados.length);
                    System.out.println("Se eliminaron los filtros correctamente");
                    mostrarEmpleados(empleados);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("La opción ingresada no es válida");
                    break;
            }
        }while(opcion!=7);
    }

    public static void mostrarEmpleados(Empleado[] arrayEmpleados){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-10s %-30s %-10s %-10s %-20s\n", "N°", "Nombre", "Edad", "Salario", "Departamento");
        System.out.println("--------------------------------------------------------------------------------");
        int numeroOrden = 1;
        for(Empleado empleado : arrayEmpleados){
            if(empleado != null){
                System.out.printf("%-10s %-30s %-10s %-10s %-20s\n", numeroOrden, empleado.getNombre(), empleado.getEdad(), empleado.getSalario(), empleado.getDepartamento());
                numeroOrden++;
            }
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static Empleado[] filtrarEmpleados(Empleado[] arrayEmpleados, String nombre, int edad, double salario, String departamento){
        Empleado[] arrayFiltrado = new Empleado[arrayEmpleados.length];
        int indice = 0;
        if(nombre != null && edad == 0 && salario == 0 && departamento == null){
            for(Empleado empleado : arrayEmpleados){
                if(empleado != null && empleado.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                    arrayFiltrado[indice]=empleado;
                    indice++;
                }
            }
        }

        if(nombre == null && edad == 0 && salario == 0 && departamento != null){
            for(Empleado empleado : arrayEmpleados){
                if(empleado != null && empleado.getDepartamento().toLowerCase().contains(departamento.toLowerCase())){
                    arrayFiltrado[indice]=empleado;
                    indice++;
                }
            }
        }

        if(nombre == null && edad != 0 && salario == 0 && departamento == null){
            for(Empleado empleado : arrayEmpleados){
                if(empleado != null && empleado.getEdad()<edad && edad>0){
                    arrayFiltrado[indice]=empleado;
                    indice++;
                }
            }
        }

        if(nombre == null && edad == 0 && salario != 0 && departamento == null){
            for(Empleado empleado : arrayEmpleados){
                if(empleado != null && empleado.getSalario()< salario && salario>0){
                    arrayFiltrado[indice]=empleado;
                    indice++;
                }
            }
        }

        return arrayFiltrado;
    }

    public static Empleado[] ordenarEmpleados(Empleado[] arrayEmpleados,String criterio){
        int cantidadDeElementos = 0;
        for(Empleado empleado : arrayEmpleados){
            if(empleado!=null){
                cantidadDeElementos++;
            }
        }

        if(criterio.equals("edad")){
            for(int i=0; i<cantidadDeElementos-1;i++){
                for(int j=0; j<cantidadDeElementos-1-i; j++){
                    if( arrayEmpleados[j].getEdad()>arrayEmpleados[j+1].getEdad() ){
                        Empleado aux=arrayEmpleados[j];
                        arrayEmpleados[j]=arrayEmpleados[j+1];
                        arrayEmpleados[j+1]=aux;
                    }
                }
            }
        }
        if(criterio.equals("salario")){
            for(int i=0; i<cantidadDeElementos-1;i++){
                for(int j=0; j<cantidadDeElementos-1-i; j++){
                    if(arrayEmpleados[j]!=null && arrayEmpleados[j].getSalario()>arrayEmpleados[j+1].getSalario()){
                        Empleado aux=arrayEmpleados[j];
                        arrayEmpleados[j]=arrayEmpleados[j+1];
                        arrayEmpleados[j+1]=aux;
                    }
                }
            }
        }

        if(criterio.equals("nombre")){
            for(int i=0; i<cantidadDeElementos-1;i++){
                for(int j=0; j<cantidadDeElementos-1-i; j++){
                    if(arrayEmpleados[j]!=null && arrayEmpleados[j].getNombre().compareTo(arrayEmpleados[j+1].getNombre())>0){
                        Empleado aux=arrayEmpleados[j];
                        arrayEmpleados[j]=arrayEmpleados[j+1];
                        arrayEmpleados[j+1]=aux;
                    }
                }
            }
        }

        if(criterio.equals("departamento")){
            for(int i=0; i<cantidadDeElementos-1;i++){
                for(int j=0; j<cantidadDeElementos-1-i; j++){
                    if(arrayEmpleados[j]!=null && arrayEmpleados[j].getDepartamento().compareTo(arrayEmpleados[j+1].getDepartamento())>0){
                        Empleado aux=arrayEmpleados[j];
                        arrayEmpleados[j]=arrayEmpleados[j+1];
                        arrayEmpleados[j+1]=aux;
                    }
                }
            }
        }

        return arrayEmpleados;
    }

    public static Empleado buscarPorNombre(Empleado[] arrayEmpleados, String nombreBuscado){
        Empleado empleadoEncontrado = null;
        for(Empleado empleado: arrayEmpleados){
            if(empleado!=null && empleado.getNombre().toLowerCase().contains(nombreBuscado.toLowerCase())){
                empleadoEncontrado=empleado;
                return empleadoEncontrado;
            }
        }
        return empleadoEncontrado;
    }

    public static Empleado incrementarSalario(Empleado empleado, double porcentaje){
        if(empleado!=null && porcentaje>0){
            double aumento= empleado.getSalario()*porcentaje;
            double nuevoSalario = empleado.getSalario()+aumento;
            empleado.setSalario(nuevoSalario);
        }
        return empleado;
    }



}
