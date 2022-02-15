import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class buttonHandler implements ActionListener {
    private JTextField f;
    private centerPanel center;
    private ArrayList<String> sozluk = new ArrayList<String>();
    private ArrayList<String> sozlukAll = new ArrayList<String>();
    private ArrayList<String> usedWords = new ArrayList<String>();
    private ArrayList<String> pcUsedWords = new ArrayList<String>();
    private ArrayList<String> boardWords = new ArrayList<String>();
    private Random rand = new Random();
    private ImageIcon chatL = new ImageIcon("icons//chatL.png");
	private ImageIcon chatR = new ImageIcon("icons//chatR.png"); 
	private String firstWord;
	private infopanel infoPanel;

    public buttonHandler(JTextField f, infopanel infoPanel, centerPanel center) {
        this.f = f;
        this.center = center;
        this.infoPanel = infoPanel;
        getWords(sozluk);
        getWords(sozlukAll);
        firstWord = pickRandom();
        boardWriter();
        } 
   
    public void getWords(ArrayList<String> array){
        try {

            File kelimeler = new File("sozluk.txt");
            Scanner reader = new Scanner(kelimeler); 
    
            while(reader.hasNextLine()){
                array.add(reader.nextLine());
            }

        }catch (Exception fileNotFoundException) {
            System.out.println("fileNotFoundException");
        }
    }
    public String pickRandom() {
    	int random = rand.nextInt(sozluk.size());
    	String kelime = sozluk.get(random);
    	sozluk.remove(random);
    	pcUsedWords.add(kelime);
    	boardWords.add(kelime);
    	return kelime;
    }
    
    public String pickWord(String word) {
    	String lastLetter = word.substring(word.length()-1);
    	int rast;
    	String wordLast;
    	do {
    		rast = rand.nextInt(sozluk.size());
			wordLast = sozluk.get(rast);
			
		} while (!wordLast.substring(0,1).equals(lastLetter));
    	
    	sozluk.remove(rast);
    	boardWords.add(wordLast);
    	pcUsedWords.add(wordLast);
    	return wordLast;
    }
    public void setIcon(int i,int j) {
    	if (j % 2 == 0) {
			center.getButton(i, j).setIcon(chatL);
		}
    	if (j % 2 == 1) {
			center.getButton(i, j).setIcon(chatR);
		}
    
    }
    public void simp(int i,int j, int k) {
    	center.getButton(i, j).setText(boardWords.get(k));
		setIcon(i, j);
    	
    }
    public void boardWriter() {
    	if (boardWords.size() == 1) {
    		simp(5,0,0);
		}
    	else if (boardWords.size() == 2) {
    		simp(3,0,0);
    		
    		simp(4,1,1);
    		
    		center.getButton(5, 0).setText(pickWord(usedWords.get(usedWords.size()-1)));
    		setIcon(5, 0);

		}
    	else if (boardWords.size() == 4) {
    		simp(1,0,0);
    		
    		simp(2,1,1);
    		
    		simp(3,0,2);
    		
    		simp(4,1,3);
    		
    		center.getButton(5, 0).setText(pickWord(usedWords.get(usedWords.size()-1)));
    		setIcon(5, 0);
		}
    	else if (boardWords.size() > 4) {
    		simp(0,1,boardWords.size()-5);
    		
    		simp(1,0,boardWords.size()-4);

    		simp(2,1,boardWords.size()-3);
    		
    		simp(3,0,boardWords.size()-2);
    		
    		simp(4,1,boardWords.size()-1);
    		
    		center.getButton(5, 0).setText(pickWord(usedWords.get(usedWords.size()-1)));
            setIcon(5, 0);
		}
    }
    
    public int checkWord(String word) {
    	if (word.equals("")) {
			return 2;//boş cevap girildi
		} 
    	else if (!sozlukAll.contains(word)) {
			return 6;//kelime sözlükte yok
		}
    	
    	else if (!word.substring(0,1).equals(pcUsedWords.get(pcUsedWords.size()-1).substring(pcUsedWords.get(pcUsedWords.size()-1).length()-1))) {
			return 3;//kelime önceki kelimenin son harfiyle uyuşmuyor
		}
    	
    	else if (pcUsedWords.contains(word)) {
			return 5;//kelimeyi bilgisayar daha önce kullanmış
		}
    	
    	else if (usedWords.contains(word)) {
			return 4;//kelimeyi daha önce oyuncu kullanmış
		}
    	
    	else if (word.substring(0,1).equals(pcUsedWords.get(pcUsedWords.size()-1).substring(pcUsedWords.get(pcUsedWords.size()-1).length()-1))) {
			usedWords.add(word);
			boardWords.add(word);
			sozluk.remove(word);
			return 1;//doğru cevap
		}
    	else {
			return 0;
		}
    }
	public void actionPerformed(ActionEvent e) {
		String input = f.getText().toLowerCase();
		f.setText("");
		if (checkWord(input) == 1) {
			boardWriter();
			infoPanel.plusTextField();
		}
		else if (checkWord(input) == 2) {
			JOptionPane.showMessageDialog(f, "Boş Cevap Giremezsiniz !", "Hey!", JOptionPane.WARNING_MESSAGE);
		}
		else if (checkWord(input) == 3) {
			JOptionPane.showMessageDialog(f, "Bilgisayarın Yazdığı Kelimenin Son Harfine Dikkat Et !", "Hey!", JOptionPane.WARNING_MESSAGE);
		}
		else if (checkWord(input) == 4) {
			JOptionPane.showMessageDialog(f, "Bu Kelimeyi Daha Önce Kullandın !", "Hey !", JOptionPane.WARNING_MESSAGE);
		}
		else if (checkWord(input) == 5) {
			JOptionPane.showMessageDialog(f, "Bu Kelimeyi Daha Önce Bilgisayar Kullandı !", "Hey !", JOptionPane.WARNING_MESSAGE);
		}
		else if (checkWord(input) == 6) {
			JOptionPane.showMessageDialog(f, "Bu Kelime Sözlüğümüzde Yok. Dikkatli ol !", "Hey !", JOptionPane.WARNING_MESSAGE);
		}
		else if (checkWord(input) == 0) {
			JOptionPane.showMessageDialog(f, "İlk Defa Böyle Bir Hata Aldık !", "Hey !", JOptionPane.WARNING_MESSAGE);
		}
		}
	}

  

