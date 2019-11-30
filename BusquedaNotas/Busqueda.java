import java.io.*;
/**
 * Esta clase define como buscar una "nota" en un txt que guardara los datos
 * @author: Parada Martinez Erwin Eli
 * @version: 29/11/2019
 */
public class Busqueda
{
    /** método que realiza la busqueda de un dato en una cadena
     *  @param cadena La cadena en la que se va a buscar coincidencias
     *  @param dato El dato define el string a encontrar
     *  @return Un substring donde se encontro la coincidencia
     */
    public static String busqueda(String cadena,String dato){
        String a=""; /** variable local auxiliar "a" */
        String [] b=cadena.split(":"); /** arreglo que guarda todas las coincidencias */
        
            if(cadena.toLowerCase().contains(dato.toLowerCase())){ /** if comparador de coincidencias */
                a+=b[0]+",";
            } /** fin del if*/

        return a.substring(0,a.length());
    }//Cierre del método
    /** método que realiza la lectura de un archivo bajo determinado nombre
     *  @param nombre que define el nombre del archivo del cual se va a leer
     *  @throw Una IOException
     *  @return Un string que guarda todo el archivo si hay archivo, en caso contrario retorna null
     */
    public static String leerarchivo(String nombre){
        String cadena=""; /** variable local auxiliar "cadena" */
        String cadena2=""; /** variable local auxiliar "cadena2" */
        try{ /** inicio del try/catch*/
            FileReader fr=new FileReader(nombre+".txt"); /** creacion de un file reader*/
            BufferedReader br= new BufferedReader(fr); /** icreacion de un bufered reader*/
            
            while((cadena=br.readLine())!=null){ /** inicio de ciclo while (recorrido linea por linea)*/
                cadena2+=cadena+",";
                
            }/** fin de ciclo while*/
            
        }catch(Exception e){
            System.out.println("no hay archivo");
            return "";
        } /** fin del try/catch*/
        
        return cadena2;/** regreso de la cadena con el archvio*/
    }//Cierre del método
    /** método main para probar el codigo
     *  @param Array String de argumentos
     */
    public static void main(String []args){
        String []a=leerarchivo("nota").split(","); /** invoca el metodo leer archivo y en las separaciones por comas lo introduce en una arreglo*/
        String s=""; /** variable aux "s"*/
        for(String b:a){ /** for each para recorrer el arreglo*/
            s+=busqueda(b,"una"); /** metodo de busca para encontrar coincidencias*/
        }/** fin del for each*/
        System.out.println("las notas con el nombre: "+s+" contienen la palabra buscada");/** impresion de la variable string*/
    }//Cierre del método
}
