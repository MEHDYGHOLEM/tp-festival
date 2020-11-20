package festi.is.vall.com.au.AppliMobi;

class Shape
{
    private String id;
    private String name;
    private String info;
    private String jour;
    private String scene;
    private int image;

    public Shape(String id, String name,String info,String jour,String scene, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.info= info;
        this.jour = jour ;
        this.scene = scene;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setinfo(String info) {
        this.info = info;
    }

    public String getjour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
