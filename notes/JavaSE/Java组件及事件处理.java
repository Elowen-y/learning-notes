组件及事件处理
1. UI 用户界面（User interface）：
	包含软、硬件设计，囊括了GUI（图形用户界面）、UE（用户体验）及ID（交互设计）。
   GUI 图形用户界面（Graphical User Interface）：
	采用图形方式显示的计算机操作用户界面。
	
2. javax.swing：一系列图形用户界面的控件的java类库。
	容器：
		JComponent是Container的子类,因此JComponent子类创建的组件也都是容器。容器经常用来添加组件。
	
		1. JFrame：底层容器（窗体）
			javax.swing.JFrame：
				构造方法：
					JFrame() 构造一个初始时不可见的新窗体。
					JFrame(String title) 创建一个新的、初始不可见的、具有指定标题的 Frame。
					
				成员方法：
					void setVisible(boolean b) 设置窗口是否可见，窗口默认是不可见的。
					
					void setSize(int width, int height) 设置大小。
					
					Container getContentPane() 返回此窗体的 contentPane 对象
					
					void setDefaultCloseOperation(int operation) 设置单击窗体右上角的关闭图标后，程序会做出怎样的处理。
						参数：
							DO_NOTHING_ON_CLOSE：不执行任何操作。
							HIDE_ON_CLOSE：默认。隐藏当前窗口。
							DISPOSE_ON_CLOSE：隐藏当前窗口，并释放窗体占有的其他资源。
							EXIT_ON_CLOSE：结束窗口所在的应用程序。
							
					void setBounds(int x, int y, int width, int height) 移动组件并调整其大小。
						参数：长，宽，横间距，纵间距
						
					void setResizable(boolean resizable) 设置此窗体是否可由用户调整大小。默认可以。
					
					void setLayout(LayoutManager layout) 设置布局。		LayoutManager layout是布局对象。
						参数：
							FlowLayout：流布局
								该布局中组件按照加入的先后顺序从左向右排列，组件之间的默认水平和垂直间隙是5个像素，组件大小为默认的最佳大小。
								
							BorderLayout：边界布局（默认布局）
								边框布局分为东、南、西、北、中五个区
								五个区的常量值：
									BorderLayout.NORTH：北区
									BorderLayout.SOUTH：南区
									BorderLayout.WEST：西区
									BorderLayout.EAST：东区
									BorderLayout.CENTER：中间区
							
							GridBagLayout：网格布局
								eg：GridLayout  gridLayout = new GridLayout(3,3); // 创建一个三行三列的表格布局对象。
							
							null：自定义布局
								通过控件调用setBounds(x,y,width,height)
							
					frame.getContentPane().setBackground(Color.blue); // 设置窗体内容面板背景色
					
				注意：创建JFrame对象时，【必须】设置大小setSize()，设置窗口可见setVisible(true)
				
			窗体对象的创建：
				法一：直接创建JFrame类对象，该对象就是一个窗体。
				法二：定义一个类，该类继承自JFrame，那么该类创建的对象也是一个窗体对象。
				
		2. JPanel：面板
			javax.swing.JPanel：
				构造方法：
					JPanel()
					JPanel(LayoutManager layout)
					
			使用JPanel创建面板,再向这个面板添加组件,然后把这个面板添加到其它容器中。add

		3. JScrollPane：滚动窗格
			javax.swing.JScrollPane：
				构造方法：
					JScrollPane(Component view)：创建一个显示指定组件内容的 JScrollPane，只要组件的内容超过视图大小就会显示水平和垂直滚动条。
					
			可以把一个组件（也只能是一个组件，例如文本区）添加到一个滚动窗格中，然后就可以通过滚动条来观看该组件。
			
		4. JOptionPane：有助于方便地弹出要求用户提供值或向其发出通知的标准对话框。（api文档查看）
		
		
	组件：
		文本组件：
			1. JLabel：标签组件
				构造方法：
					JLabel(String text)	以指定的文本创建 JLabel 对象
					JLabel(Icon image) 	以指定的图像创建 JLabel 对象
					JLabel(String text, int horizontalAlignment) 创建具有指定文本和水平对齐方式的 JLabel 实例。
						horizontalAlignment：LEFT、CENTER、RIGHT、LEADING 或 TRAILING。
					
				成员方法：
					void setFont(Font font) 设置此组件的字体。
			
			
			2. JTextField：文本输入组件
				构造方法：
					JTextField()：构造一个新的文本输入框 
					JTextField(String text)：构造一个新的文本输入框 ，以指定文本作为初始文本。
					JTextField(String text, int columns)：构造一个用指定文本和列初始化的新 TextField。
					
				成员方法：
					String getText()：返回文本框中内容
					
			3. JTextArea：文本区
				构造方法：
					JTextArea(int rows, int columns)
					JTextArea(String text, int rows, int columns)
					
				成员方法：
					String getText() 返回此 TextComponent 中包含的文本。
					void setFont(Font f) 设置当前字体。
			
			4. JPassword：密码框组件
				构造方法：
					JPasswordField()
					JPasswordField(int columns)
					JPasswordField(String text)
					JPasswordField(String text, int columns)
					
				成员方法：
					char[] getPassword() 返回此 TextComponent 中所包含的文本。
		
		选择组件：
			5. JButton：按钮组件
				构造方法：
					JButton(String text)：创建带文本的按钮
					JButton(String text, Icon icon)：创建带文本和图标的按钮
			
			6. JCheckBox：复选框按钮组件
				构造方法：
					JCheckBox(String text)：用指定的文本创建【初始非选中】的复选框。
					JCheckBox(String text, boolean selected)：用指定文本创建一个复选框，并指定是否初始选中该复选框
			
			7. JRadioButton：单选框按钮组价
				构造方法：
					JRadioButton(String text)：用指定的文本创建【非选中】的单选按钮
					JRadioButton(String text, boolean selected)：：用指定的文本和选择状态创建单选按钮
					
			单选按钮组 - ButtonGroup
				构造方法：
					ButtonGroup()：创建分组对象
					
				成员方法：
					void add(AbstractButton b)：将按钮添加到组中。
			
			8. JComboBox：下拉列表框
				构造方法：
					JComboBox()：创建具有默认数据模型的 JComboBox。
					JComboBox(Object[] items)：创建包含指定数组中的元素的 JComboBox。
					
				成员方法：
					void addItem(Object anObject) 为项列表添加项。
					Object getItemAt(int index) 返回指定索引处的列表项。
					Object getSelectedItem() 返回当前所选项。 
					int getSelectedIndex()：返回当前选择项的索引位置 
					
		菜单组件：
			9. JMenuBar：菜单栏
			10. JMenu：菜单
			11. JMnuItem：子菜单
			12. 快捷键：Java提供了两种方式来设置快捷键：setMnemonic和setAccelerator。
				Mnemonic用于在菜单中快速导航。
					菜单JMenu：快捷方式只能用单个字母(A-Z)。
						菜单.setMnemonic(KeyEvent,VK_A); // A可换成其他的大写字母。
					菜单项JMnuItem：除了可以设置为单个字母(A-Z)外，还可以设置为ALT/CTRLl+字母键。
						菜单项.setMnemonic(KeyEvent.VK_A); // A可换成你想设置的大写字母。
						JMenuItem m1 = new JMenu(“name”, KeyEvent.VK_A); // A可换成你想设置的大写字母。
						
				Accelerator用于全局快捷键。
						
				eg：
					JMenuBar menuBar = new JMenuBar();
					JMenu fileMenu = new JMenu("File");
					JMenuItem newItem = new JMenuItem("New");
					menuBar.add(fileMenu);
					fileMenu.add(newItem);

				如果你希望用户按下Alt+F来打开File菜单：
					fileMenu.setMnemonic(KeyEvent.VK_F);
					newItem.setMnemonic(KeyEvent.VK_N);
					
				如果你希望用户按下Ctrl+N来创建一个新文件：
					newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
					
				最后，需要将JMenuBar添加到你的JFrame中：
					frame.setJMenuBar(menuBar);
					
		其他组件：
			13. JTable：表格组件
				构造方法：
					JTable(Object[][] rowData, Object[] columnNames) 构造一个 JTable 来显示二维数组 rowData 中的值，其列名称为 columnNames。
				成员方法：
					int getSelectedColumn() 返回第一个选定列的索引；如果没有选定的列，则返回 -1。
					Object getValueAt(int row, int column) 返回 row 和 column 位置的单元格值。 
		
	帮助类：
		1. Color
		2. Font
		3. Dimension
		
3. 事件处理机制：
	事件响应三要素：
		事件源
		事件：
			ActionEvent事件：组件
			WindowEvent事件：窗体操作
			KeyEvent事件：键盘操作
			MouseEvent事件：鼠标操作
		事件处理者
		
	使用步骤：
		1. 创建事件源组件
		2. 自定义类，实现XXXListner接口，重写方法
		3. 创建事件监听器对象（自定义类对象）
		4. 调用事件源组件对象的addXXXListener()方法完成注册监听
		
4. 事件：
	ActionEvent（动作事件：按钮按下）。
	AdjustmentEvent（调节事件：调节滚动条上数值）。
	ItemEvent（项目事件：修改下拉列表中的选项）。
	TextEvent（文本事件：文本对象改变）。
	
	MouseEvent包含的事件：
		MOUSE_PRESSED： 当鼠标按下时触发该事件。
		MOUSE_RELEASED：当鼠标释放时触发该事件。
		MOUSE_CLICKED： 当点击鼠标时触发该事件。
		MOUSE_ENTERED： 当鼠标进入指定区域时触发该事件。
		MOUSE_EXITED:   当鼠标退出指定区域时触发该事件。
		
	MouseMotionEvent包含的事件：
		MOUSE_MOVED:    当鼠标的位置发生改变时触发该事件。
		MOUSE_DRAGGED:  当鼠标按下且位置发生改变时触发该事件。
		
	KeyEvent事件包含：
		KEY_PRESSED：   当按下键盘中某个键时触发。
		KEY_RELEASED：  当释放键盘中按下的键时触发。
		KEY_TYPED：     确定按下的是那个键值，通常是一个字符，对应pressed事件。