package Calculos;

public class triangulo 
{
    private int base;
    private int altura;
    private int area;
    private int perimetro;
    
    public triangulo(String base, String altura)
    {
        this.setBase(Integer.parseInt(base));
        this.setAltura(Integer.parseInt(altura));
    }
    
    public void setBase(int base)
    {
        this.base=base;
    }

    public int getBase()
    {
        return base;
    }

    public void setAltura (int altura)
    {
        this.altura=altura;
    }

    public int getAltura()
    {
        return altura;
    }

    public void setArea(int area)
    {
         this.area=area;
    }
    
    public int getArea()
    {
        return area;
    }
    
    public void setPerimetro(int perimetro)
    {
        this.perimetro=perimetro;
    }
    
    public int getPerimetro()
    {
        return perimetro;
    }
    
    public void sacarArea()
    {
        int calcularArea=(this.getBase()*this.getAltura())/2;
        this.setArea(calcularArea);
    }
    
    public void sacarPerimetro()
    {
        int calcularPerimetro=this.getBase()*3;
        this.setPerimetro(calcularPerimetro);
    }
}