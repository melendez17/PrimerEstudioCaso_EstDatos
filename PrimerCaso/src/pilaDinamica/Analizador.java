package pilaDinamica;

public class Analizador {

    public static int precedencia(char operador) {

        switch (operador) {
            //En esta función vamos a definir la precedencia de cada uno de los operadores, es decir su prioridad por lo que podemos ver que la suma y resta tienen la mejor precedencia y ahí va subiendo a la multiplicacion, division y luego potencia

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }
    }

    // este método nos va a yudar a convertir una expresión aritmetica infija en una postfija utilizando una pila como lo expliqué a lo largo del documento
    public static String infijaAPostfija(String expresion) {

        //almacenaremos los operadores y parentesis
        Pila pila = new Pila();

        //aquí se va construyendo la expresión postfija, con respecto al documento es como la via de salida
        String resultado = "";

        //vamos a recorrerlo caracter por caracter
        for (int i = 0; i < expresion.length(); i++) {

            //obtenemos el caracter actual
            char c = expresion.charAt(i);

            //si es un numero o letra entonces es un operando e iría directamente a la "fila" que en este caso es el resultado donde se van a ir concatenando
            if (Character.isLetterOrDigit(c)) {

                resultado += c; //acá se concatena
            }

            else if (c == '(') { //si es parentesis abriendo automáticamente se agrega a la pila

                pila.push(c);
            }

            else if (c == ')') { //Si es un parentesis pero cerrandose entonces haremos algunas validaciones primero

                while (!pila.estaVacia() //Si la pila no está vacía, vamos a ir sacando todo lo de la pila y agregandolo al resultado hasta que nos encontremos con el parentesis abierto y entonces lo eliminaremos
                        && pila.peek() != '(') {

                    resultado += pila.pop();
                }

                pila.pop(); //con esto ya eliminamos el parentesis izquiero
            }

            else {

                //cuando la pila no esté vacía, es decir que haya algún caracter tenemos que analizar la precedencia o prioridad del caracter actuar y compararlo
                while (!pila.estaVacia() //mientras no esté vacío
                        && precedencia(c) //la presedencia del caracter
                        <= precedencia(pila.peek())) { //sea menor o igual a la presedencia que tenemos en la pila
                    //entonces si el que viene tiene menor presedencia (-) < (*) entonces el * debe salir a actuar.

                    resultado += pila.pop(); //añadimos el que estaba en la pila concatenado al resultado
                }

                pila.push(c); //añadimos el nuevo a la pila
            }
        }

        while (!pila.estaVacia()) { //una vez que terminamos todo, mientras la pila tenga algo entonces debemos hacer lo siguiente:

            resultado += pila.pop(); //sacar todo lo que nos quede en la pila y agregarlo al resultado
        }

        return resultado;
    }
}