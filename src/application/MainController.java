package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainController {

	@FXML private TabPane tabPane;
	@FXML private Tab tabHex;
	@FXML private Tab tabDecimal;
	@FXML private Tab tabBinary;
	@FXML private Tab tabAbout;
	@FXML private AnchorPane ancHex;
	@FXML private AnchorPane ancDec;
	@FXML private AnchorPane ancBin;

	@FXML private TextField txHexInput;
	@FXML private Button btHexToDec;
	@FXML private Button btHexToBin;
	@FXML private Button btHexToAscii;
	@FXML private TextField txHexToDec;
	@FXML private TextField txHexToBin;
	@FXML private TextField txHexToAscii;
	@FXML private Button btHexAnd;
	@FXML private TextField txHexAndInput1;
	@FXML private TextField txHexAndInput2;
	@FXML private TextField txHexAndOutput;
	@FXML private Button btHexOr;
	@FXML private TextField txHexOrInput1;
	@FXML private TextField txHexOrInput2;
	@FXML private TextField txHexOrOutput;
	@FXML private Button btHexXor;
	@FXML private TextField txHexXorInput1;
	@FXML private TextField txHexXorInput2;
	@FXML private TextField txHexXorOutput;
	@FXML private Button btHexShl;
	@FXML private TextField txHexShlInput1;
	@FXML private TextField txHexShlInput2;
	@FXML private TextField txHexShlOutput;
	@FXML private Button btHexShr;
	@FXML private TextField txHexShrInput1;
	@FXML private TextField txHexShrInput2;
	@FXML private TextField txHexShrOutput;
	@FXML private Button btHexNot;
	@FXML private TextField txHexNotInput;
	@FXML private TextField txHexNotOutput;
	@FXML private TextField txAsciiToHex;
	@FXML private Button btAsciiToHex;
	@FXML private TextField txAsciiToHexOutput;
	@FXML private Button btHexClear;
	@FXML private TextField txDecInput;
	@FXML private Button btDecToHex;
	@FXML private Button btDecToBin;
	@FXML private Button btDecToAscii;
	@FXML private TextField txDecToHex;
	@FXML private TextField txDecToBin;
	@FXML private TextField txDecToAscii;
	@FXML private Button btDecAnd;
	@FXML private TextField txDecAndInput1;
	@FXML private TextField txDecAndInput2;
	@FXML private TextField txDecAndOutput;
	@FXML private Button btDecOr;
	@FXML private TextField txDecOrInput1;
	@FXML private TextField txDecOrInput2;
	@FXML private TextField txDecOrOutput;
	@FXML private Button btDecXor;
	@FXML private TextField txDecXorInput1;
	@FXML private TextField txDecXorInput2;
	@FXML private TextField txDecXorOutput;
	@FXML private Button btDecShl;
	@FXML private TextField txDecShlInput1;
	@FXML private TextField txDecShlInput2;
	@FXML private TextField txDecShlOutput;
	@FXML private Button btDecShr;
	@FXML private TextField txDecShrInput1;
	@FXML private TextField txDecShrInput2;
	@FXML private TextField txDecShrOutput;
	@FXML private Button btDecNot;
	@FXML private TextField txDecNotInput;
	@FXML private TextField txDecNotOutput;
	@FXML private TextField txAsciiToDecInput;
	@FXML private Button btAsciiToDec;
	@FXML private TextField txAsciiToDecOutput;
	@FXML private Button btDecClear;
	@FXML private TextField txBinInput;
	@FXML private Button btBinToHex;
	@FXML private Button btBinToDec;
	@FXML private Button btBinToAscii;
	@FXML private TextField txBinToHex;
	@FXML private TextField txBinToDec;
	@FXML private TextField txBinToAscii;
	@FXML private Button btBinAnd;
	@FXML private TextField txBinAndInput1;
	@FXML private TextField txBinAndInput2;
	@FXML private TextField txBinAndOutput;
	@FXML private Button btBinOr;
	@FXML private TextField txBinOrInput1;
	@FXML private TextField txBinOrInput2;
	@FXML private TextField txBinOrOutput;
	@FXML private Button btBinXor;
	@FXML private TextField txBinXorInput1;
	@FXML private TextField txBinXorInput2;
	@FXML private TextField txBinXorOutput;
	@FXML private Button btBinShl;
	@FXML private TextField txBinShlInput1;
	@FXML private TextField txBinShlInput2;
	@FXML private TextField txBinShlOutput;
	@FXML private Button btBinShr;
	@FXML private TextField txBinShrInput1;
	@FXML private TextField txBinShrInput2;
	@FXML private TextField txBinShrOutput;
	@FXML private Button btBinNot;
	@FXML private TextField txBinNotInput;
	@FXML private TextField txBinNotOutput;
	@FXML private TextField txAsciiToBinInput;
	@FXML private Button btAsciiToBin;
	@FXML private TextField txAsciiToBinOutput;
	@FXML private Button btBinClear;

	public static String numToAscii(String input, int base) {
		StringTokenizer st = new StringTokenizer(input);
		StringBuilder builder = new StringBuilder();
	    while (st.hasMoreTokens()) {
	    	builder.append((char)StringToInt(st.nextToken(), base));
	    }
	    return builder.toString();
	}

	public static String asciiToNum(String input, int base) {
		StringBuilder builder = new StringBuilder();
		for(Character c : input.toCharArray()) {
			builder.append(convertBase((int)c, base));
		}
		return builder.toString();
	}

	public static int StringToInt(String input, int base) {
		input = input.toUpperCase();
		int index = 0;
		int value = 0;

		if(input.charAt(0) == '-') {
			index++;
		}

		while(index < input.length()) {
			value = (value * base);
			value = (value + (input.charAt(index) - '0' - (input.charAt(index) >= 'A' ? 7 : 0)));
			index++;
		}

		if(input.charAt(0) == '-') {
			value = value * -1;
		}

		return value;
	}

    public static String convertBase( int number, int radix ) {

        List<String> remainder = new ArrayList<>();

        int count = 0;
        int numToAdd;
        String result = "";
        while( number != 0 ) {
        	numToAdd = (number % radix != 0 ? number % radix : 0);
            remainder.add( count,  "" + ((numToAdd > 9) ? ("" + (char)('0' + 7 + numToAdd)) : numToAdd) );
            number /= radix;
            try {
                result += remainder.get( count );
            } catch( NumberFormatException e ) {
                e.printStackTrace();
            }
        }
        return new StringBuffer( result ).reverse().toString();
    }

    private static void clearPaneInputs(Pane thePane) {
    	for (Node node : thePane.getChildren()) {
    		if(node instanceof Pane) {
    			clearPaneInputs((Pane)node);
    		}
    	    if (node instanceof TextField) {
    	        // clear
    	        ((TextField)node).setText("");
    	    }
    	}
    }

	 @FXML
	 private void buttonAction(ActionEvent event) {
	     // Button was clicked, do something...
	     //txHexToDec.appendText(convertBase(16, 2));
		 Button b = (Button)event.getSource();

		 if(b == btHexToDec
		 || b == btHexToBin
		 || b == btDecToHex
		 || b == btDecToBin
		 || b == btBinToHex
		 || b == btBinToDec) {

			 TextField inputBox, outputBox;
			 int baseFrom, baseTo;

			 if(b == btHexToDec || b == btHexToBin) {
				 baseFrom = 16;
				 baseTo = (b == btHexToDec) ? 10 : 2;
				 inputBox = txHexInput;
				 outputBox = (b == btHexToDec) ? txHexToDec : txHexToBin;
			 }
			 else if(b == btDecToHex || b == btDecToBin){
				 baseFrom = 10;
				 baseTo = (b == btDecToHex) ? 16 : 2;
				 inputBox = txDecInput;
				 outputBox = (b == btDecToHex) ? txDecToHex : txDecToBin;
			 }
			 else if(b == btBinToHex || b == btBinToDec) {
				 baseFrom = 2;
				 baseTo = (b == btBinToHex) ? 16 : 10;
				 inputBox = txBinInput;
				 outputBox = (b == btBinToHex) ? txBinToHex : txBinToDec;
			 } else {
				 return;
			 }
			 inputBox.setText(inputBox.getText().replace(" ", ""));
			 outputBox.setText(convertBase(StringToInt(inputBox.getText(), baseFrom), baseTo));
		 } else if( b == btHexAnd
				 || b == btHexOr
				 || b == btHexXor
				 || b == btHexShl
				 || b == btHexShr
				 || b == btHexNot
				 || b == btDecAnd
				 || b == btDecOr
				 || b == btDecXor
				 || b == btDecShl
				 || b == btDecShr
				 || b == btDecNot
				 || b == btBinAnd
				 || b == btBinOr
				 || b == btBinXor
				 || b == btBinShl
				 || b == btBinShr
				 || b == btBinNot) {
			 int input1, input2, output, base;
			 TextField outputBox;

			 if(tabPane.getSelectionModel().getSelectedItem() == (tabHex)) {
				 base = 16;
			 } else if(tabPane.getSelectionModel().getSelectedItem() == (tabDecimal)) {
				 base = 10;
			 } else if(tabPane.getSelectionModel().getSelectedItem() == (tabBinary)) {
				 base = 2;
			 } else {
				 return;
			 }

			 if(b == btHexAnd) {
				 input1 = StringToInt(txHexAndInput1.getText(), base);
				 input2 = StringToInt(txHexAndInput2.getText(), base);
				 output = input1 & input2;
				 outputBox = txHexAndOutput;
			 } else if(b == btHexOr) {
				 input1 = StringToInt(txHexOrInput1.getText(), base);
				 input2 = StringToInt(txHexOrInput2.getText(), base);
				 output = input1 | input2;
				 outputBox = txHexOrOutput;
			 } else if(b == btHexXor) {
				 input1 = StringToInt(txHexXorInput1.getText(), base);
				 input2 = StringToInt(txHexXorInput2.getText(), base);
				 output = input1 ^ input2;
				 outputBox = txHexXorOutput;
			 } else if(b == btHexShl) {
				 input1 = StringToInt(txHexShlInput1.getText(), base);
				 input2 = StringToInt(txHexShlInput2.getText(), base);
				 output = input1 << input2;
				 outputBox = txHexShlOutput;
			 } else if(b == btHexShr) {
				 input1 = StringToInt(txHexShrInput1.getText(), base);
				 input2 = StringToInt(txHexShrInput2.getText(), base);
				 output = input1 >> input2;
				 outputBox = txHexShrOutput;
			 } else if(b == btHexNot) {
				 input1 = StringToInt(txHexNotInput.getText(), base);
				 output = ~input1;
				 outputBox = txHexNotOutput;
			 } else if(b == btDecAnd) {
				 input1 = StringToInt(txDecAndInput1.getText(), base);
				 input2 = StringToInt(txDecAndInput2.getText(), base);
				 output = input1 & input2;
				 outputBox = txDecAndOutput;
			 } else if(b == btDecOr) {
				 input1 = StringToInt(txDecOrInput1.getText(), base);
				 input2 = StringToInt(txDecOrInput2.getText(), base);
				 output = input1 | input2;
				 outputBox = txDecOrOutput;
			 } else if(b == btDecXor) {
				 input1 = StringToInt(txDecXorInput1.getText(), base);
				 input2 = StringToInt(txDecXorInput2.getText(), base);
				 output = input1 ^ input2;
				 outputBox = txDecXorOutput;
			 } else if(b == btDecShl) {
				 input1 = StringToInt(txDecShlInput1.getText(), base);
				 input2 = StringToInt(txDecShlInput2.getText(), base);
				 output = input1 << input2;
				 outputBox = txDecShlOutput;
			 } else if(b == btDecShr) {
				 input1 = StringToInt(txDecShrInput1.getText(), base);
				 input2 = StringToInt(txDecShrInput2.getText(), base);
				 output = input1 >> input2;
				 outputBox = txDecShrOutput;
			 } else if(b == btDecNot) {
				 input1 = StringToInt(txDecNotInput.getText(), base);
				 output = ~input1;
				 outputBox = txDecNotOutput;
			 } else if(b == btBinAnd) {
				 input1 = StringToInt(txBinAndInput1.getText(), base);
				 input2 = StringToInt(txBinAndInput2.getText(), base);
				 output = input1 & input2;
				 outputBox = txBinAndOutput;
			 } else if(b == btBinOr) {
				 input1 = StringToInt(txBinOrInput1.getText(), base);
				 input2 = StringToInt(txBinOrInput2.getText(), base);
				 output = input1 | input2;
				 outputBox = txBinOrOutput;
			 } else if(b == btBinXor) {
				 input1 = StringToInt(txBinXorInput1.getText(), base);
				 input2 = StringToInt(txBinXorInput2.getText(), base);
				 output = input1 ^ input2;
				 outputBox = txBinXorOutput;
			 } else if(b == btBinShl) {
				 input1 = StringToInt(txBinShlInput1.getText(), base);
				 input2 = StringToInt(txBinShlInput2.getText(), base);
				 output = input1 << input2;
				 outputBox = txBinShlOutput;
			 } else if(b == btBinShr) {
				 input1 = StringToInt(txBinShrInput1.getText(), base);
				 input2 = StringToInt(txBinShrInput2.getText(), base);
				 output = input1 >> input2;
				 outputBox = txBinShrOutput;
			 }  else if(b == btBinNot) {
				 input1 = StringToInt(txBinNotInput.getText(), base);
				 output = ~input1;
				 outputBox = txBinNotOutput;
			 }else {
				 return;
			 }

			 outputBox.setText(convertBase(output, base));
		 } else if(b == btHexToAscii
				|| b == btDecToAscii
				|| b == btBinToAscii) {
			 TextField inputBox, outputBox;
			 int base;

			 if(b == btHexToAscii) {
				 inputBox = txHexInput;
				 outputBox = txHexToAscii;
				 base = 16;
			 } else if(b == btDecToAscii) {
				 inputBox = txDecInput;
				 outputBox = txDecToAscii;
				 base = 10;
			 } else if(b == btBinToAscii) {
				 inputBox = txBinInput;
				 outputBox = txBinToAscii;
				 base = 2;
			 } else {
				 return;
			 }
			 outputBox.setText(numToAscii(inputBox.getText(), base));
		 } else if(b == btAsciiToHex
				|| b == btAsciiToDec
				|| b == btAsciiToBin) {

			 TextField inputBox, outputBox;
			 int base;

			 if(b == btAsciiToHex) {
				 inputBox = txAsciiToHex;
				 outputBox = txAsciiToHexOutput;
				 base = 16;
			 } else if(b == btAsciiToDec) {
				 inputBox = txAsciiToDecInput;
				 outputBox = txAsciiToDecOutput;
				 base = 10;
			 } else if(b == btAsciiToBin) {
				 inputBox = txAsciiToBinInput;
				 outputBox = txAsciiToBinOutput;
				 base = 2;
			 } else {
				 return;
			 }

			 outputBox.setText(asciiToNum(inputBox.getText(), base));
		 } else if(b == btHexClear
				|| b == btDecClear
				|| b == btBinClear) {
			 AnchorPane anchorPane;

			 if(b == btHexClear) {
				 anchorPane = ancHex;
			 } else if(b == btDecClear) {
				 anchorPane = ancDec;
			 } else if(b == btBinClear) {
				 anchorPane = ancBin;
			 } else {
				 return;
			 }

			 clearPaneInputs(anchorPane);
		 }
	 }
}
