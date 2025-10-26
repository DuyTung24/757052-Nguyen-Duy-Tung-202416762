public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        //DigitalVideoDisc[] dvdList = { jungleDVD, cinderellaDVD };
       
        swap(jungleDVD, cinderellaDVD);
        //swap(dvdList);
        
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        
//        System.out.println("jungle dvd title: " + dvdList[0].getTitle());
//        System.out.println("cinderella dvd title: " + dvdList[1].getTitle());
        
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    
    }


    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    
  //Use array to swap object 
//    public static void swap(DigitalVideoDisc[] dvds) {
//        DigitalVideoDisc tmp = dvds[0];
//        dvds[0] = dvds[1];
//        dvds[1] = tmp;
//    }
    
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}