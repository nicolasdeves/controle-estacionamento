public class ControleEstacionamento{
  public static void main (String args[]){
    String menu = " CONTROLE ESTACIONAMENTO \n\n"+
      "[C] ENTRAR CARRO \n"+
      "[M] ENTRAR MOTO \n"+
      "[V] SAIR CARRO \n"+
      "[N] SAIR MOTO \n"+
      "[D] CONSULTAR DADOS \n"+
      "[Z] ZERAR DADOS \n"+
      "[X] SAIR \n\n"+
      "DIGITE UMA OPÇÃO \n";
    
    String opcao = " ";
    
    int carros = 0;
    int motos = 0;
    
    int maxCarros = 3;
    int maxMotos = 2;
    
    int carrosDia = 0;
    int motosDia = 0;
    
    
    
    while(!opcao.equals("X")){
      
      int vagasCarro = (maxCarros - carros);
      int vagasMoto = (maxMotos - motos);
      
      opcao = Entrada.leiaString(menu + "\n Vagas de carro: " + vagasCarro + "/" + maxCarros + " \n Vagas moto: " + vagasMoto+ "/" + maxMotos).toUpperCase();
      
      if(opcao.equals("C")){
        if (carros == maxCarros){
          System.out.println("Estacionamento para carros CHEIO");
        }
        else{
          carros++;
          carrosDia++;
          System.out.println("Carro registrado!");
        }
      }
      
      if(opcao.equals("M")){
        if (motos == maxMotos){
          System.out.println("Estacionamento para motos CHEIO");
        }
        else{
          motos++;
          motosDia++;
          System.out.println("Moto registrada!");
        }
      }
      
      if(opcao.equals("V")){
        if (carros == 0){
          System.out.println("Estacionamento para carros VAZIO");
        }
        else{
          System.out.println("Carro saiu");
          carros--;
        }
      }
      
      if(opcao.equals("N")){
        if (motos == 0){
          System.out.println("Estacionamento para motos VAZIO");
        }
        else{
          System.out.println("Moto saiu");
          motos--;
        }
      }
      
      if (opcao.equals("Z")){
        carros = 0;
        motos = 0;
      }
      
      if (opcao.equals("D")){
        System.out.println("---- DADOS ----");
        System.out.println();
        System.out.println("Vagas de carro disponíveis: " + vagasCarro);
        System.out.println("Vagas de moto disponíveis: " + vagasMoto);
        System.out.println();
        System.out.println("Carros estacionados no momentos: " + carros);
        System.out.println("Motos estacionadas no momento: " + motos);
        System.out.println();
        System.out.println("Total de carros hoje" + carrosDia);
        System.out.println("Vagas de motos hoje: " + motosDia);
        
        
      }
      
      if (opcao.equals("X")){
        System.out.println("Você fechou o programa");
        System.out.println("-----Total de veículos hoje-----");
        System.out.println("Carros: " + carrosDia + "\nMotos: " + motosDia);
        
        Arquivo controle = new Arquivo ("ControleEstacionamento.txt");
        controle.abrirEscrita();
        controle.escreverLinha("||||Quantidade de veículos hoje|||| \nCarros: " + carrosDia + "\nMotos: " + motosDia + "\nTotal: " + (carrosDia+motosDia));
        controle.fecharArquivo();
      }
      
      
      
    }
  }
}