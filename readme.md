## 自定义控件  
1.使用convas绘制自定义控件  
2.自定义组合控件  
2.1 使用merge标签进行原始布局（因为代码要继承Relativelayout避免重复嵌套）  
2.2 定义stale属性，具体每个控件需要的属性（text，textColor，visible等）  
2.3 代码继承ViewGroup，进行具体的编写，详情见TitleBarView  
2.4 代码里使用，像系统控件一样先初始化，然后根据使用组合控件里边具体每个控件进行区别设置

