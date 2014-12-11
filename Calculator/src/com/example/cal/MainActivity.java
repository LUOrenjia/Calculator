package com.example.cal;

import com.example.cal.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button NUM0 = null;
	private Button NUM1 = null;
	private Button NUM2 = null;
	private Button NUM3 = null;
	private Button NUM4 = null;
	private Button NUM5 = null;
	private Button NUM6 = null;
	private Button NUM7 = null;
	private Button NUM8 = null;
	private Button NUM9 = null;
	private Button ADD = null;
	private Button MIN = null;
	private Button MUL = null;
	private Button DIV = null;
	private Button EQU = null;
	private Button CLEAR = null;
	private Button BACK = null;
	private Button POINT = null;
	private TextView display = null;
	private String[] buf = {"","",""};
	double num1,num2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		NUM0 = (Button)findViewById(R.id.NUM0);
		NUM1 = (Button)findViewById(R.id.NUM1);
		NUM2 = (Button)findViewById(R.id.NUM2);
		NUM3 = (Button)findViewById(R.id.NUM3);
		NUM4 = (Button)findViewById(R.id.NUM4);
		NUM5 = (Button)findViewById(R.id.NUM5);
		NUM6 = (Button)findViewById(R.id.NUM6);
		NUM7 = (Button)findViewById(R.id.NUM7);
		NUM8 = (Button)findViewById(R.id.NUM8);
		NUM9 = (Button)findViewById(R.id.NUM9);
		ADD = (Button)findViewById(R.id.ADD);
		MIN = (Button)findViewById(R.id.MIN);
		MUL = (Button)findViewById(R.id.MUL);
		DIV = (Button)findViewById(R.id.DIV);
		EQU = (Button)findViewById(R.id.EQU);
		CLEAR = (Button)findViewById(R.id.CLEAR);
		BACK = (Button)findViewById(R.id.BACK);
		POINT = (Button)findViewById(R.id.POINT);
		display = (TextView)findViewById(R.id.display);
		display.setText("");
		
		class  MyOnTouchListener_NUM implements OnTouchListener{
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					if(event.getAction() == MotionEvent.ACTION_DOWN){
						v.setBackgroundResource(R.drawable.dorber);
					}else if(event.getAction() == MotionEvent.ACTION_UP){
						v.setBackgroundResource(R.drawable.border);
						if(display.getText().toString().matches("[x÷+]"))            //正则表达式
							display.setText(((Button)v).getText());
						else{
//							if((display.getText()).toString().matches("\\d?[x÷+]\\d?")){
//								Toast.makeText(MainActivity.this, "输入数据有误，请重新输入！", Toast.LENGTH_SHORT).show();
//								display.setText("");
//							}else
							display.append(((Button)v).getText());
						}
					}					
					return false;
				}	
		}
		
		class  MyOnTouchListener_OP implements OnTouchListener{    //对+ × ÷ 按键的相应  ， 由于-可以代表负数，需要特殊处理。
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					v.setBackgroundResource(R.drawable.dorber);
				}else if(event.getAction() == MotionEvent.ACTION_UP){
					v.setBackgroundResource(R.drawable.border);
					if(display.getText().toString().equals("")){
						Toast.makeText(MainActivity.this, "输入数据有误，请重新输入！", Toast.LENGTH_SHORT).show();
					}else{
						buf[0] = display.getText().toString();
						System.out.println("buf[0]"+buf[0]);
						buf[1] = ((Button)v).getText().toString();
						System.out.println("buf[1]"+buf[1]);
						display.setText("");
						display.append(((Button)v).getText());
					}
				}					
				return false;
			}	
		}
		
		
		
		NUM0.setOnTouchListener(new MyOnTouchListener_NUM());
		NUM1.setOnTouchListener(new MyOnTouchListener_NUM());
		NUM2.setOnTouchListener(new MyOnTouchListener_NUM());
		NUM3.setOnTouchListener(new MyOnTouchListener_NUM());
		NUM4.setOnTouchListener(new MyOnTouchListener_NUM());
		NUM5.setOnTouchListener(new MyOnTouchListener_NUM());
		NUM6.setOnTouchListener(new MyOnTouchListener_NUM());
		NUM7.setOnTouchListener(new MyOnTouchListener_NUM());
		NUM8.setOnTouchListener(new MyOnTouchListener_NUM());
		NUM9.setOnTouchListener(new MyOnTouchListener_NUM());
		POINT.setOnTouchListener(new MyOnTouchListener_NUM());
		
		ADD.setOnTouchListener(new MyOnTouchListener_OP());
		MUL.setOnTouchListener(new MyOnTouchListener_OP());
		DIV.setOnTouchListener(new MyOnTouchListener_OP());
		MIN.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					v.setBackgroundResource(R.drawable.dorber);
				}else if(event.getAction() == MotionEvent.ACTION_UP){
					v.setBackgroundResource(R.drawable.border);
					if(display.getText().toString().equals("")){
						display.setText(((Button)v).getText());
					}else{
						buf[0] = display.toString();
						buf[1] = ((Button)v).getText().toString();
						display.setText("");
						display.append(((Button)v).getText());
					}
				}			
				return false;
			}
		});
		CLEAR.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					v.setBackgroundResource(R.drawable.dorber);
				}else if(event.getAction() == MotionEvent.ACTION_UP){
					v.setBackgroundResource(R.drawable.border);
					display.setText("");	
				}
				return false;
			}
		});
		BACK.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					v.setBackgroundResource(R.drawable.dorber);
				}else if(event.getAction() == MotionEvent.ACTION_UP){
					v.setBackgroundResource(R.drawable.border);
					if(display.getText().length() != 0){
						CharSequence cs = null;
						cs = display.getText(); 
						display.setText(cs.subSequence(0, cs.length()-1));
					}	
				}
				return false;
			}
		});
		
		EQU.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					v.setBackgroundResource(R.drawable.dorber);
					}else if(event.getAction() == MotionEvent.ACTION_UP){
					v.setBackgroundResource(R.drawable.border);
					// TODO Auto-generated method stub
					buf[2] = display.getText().toString();
					System.out.println(((Button)v).getText().length());
					num1 = Double.valueOf(buf[0]);
					num2 = Double.valueOf(buf[2]);
					if(buf[1].equals("+")){
//						display.setText(buf[0]+buf[1]+buf[3]+"=");
//						display.append(String.valueOf(num1+num2));
						display.setText(buf[0]+buf[1]+buf[2]+"="+String.valueOf(num1+num2));
					}
					else if(buf[1].equals("-")){
//						display.setText(buf[0]+buf[1]+buf[3]+"=");
//						display.append(String.valueOf(num1-num2));
						display.setText(buf[0]+buf[1]+buf[2]+"="+String.valueOf(num1-num2));
					}
					else if(buf[1].equals("x")){
//						display.setText(buf[0]+buf[1]+buf[3]+"=");
//						display.append(String.valueOf(num1*num2));
						display.setText(buf[0]+buf[1]+buf[2]+"="+String.valueOf(num1*num2));
					}
					else if(buf[1].equals("÷")){
//						display.setText(buf[0]+buf[1]+buf[3]+"=");
//						display.append(String.valueOf(num1/num2));
						display.setText(buf[0]+buf[1]+buf[2]+"="+String.valueOf(num1/num2));
					}
				}
				return false;
			}
		});
		
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}
