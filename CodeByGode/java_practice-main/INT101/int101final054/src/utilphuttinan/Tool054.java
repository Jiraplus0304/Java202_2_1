package utilphuttinan;

public  class Tool054 {

    public static boolean isUsable054(String string){
        return string != null && ! string.isBlank();
    }
    public static boolean isUsable054(Object[] object){
        return  object != null && object.length > 0 ;
    }
    public  static int count054(Object[] object){
        if (isUsable054(object)){
            return object.length;
        }else {
            return -1 ;
        }
    }



}
