# 主定理

递归形式：

```text
T(N) = a*T(N/b)+O(N^d)
```

```python
if log(b,a)<d:  
  T(N)=O(N^d)  
if log(b,a)>d: 
  T(N)=O(N^log(b,a))
if log(b,a)==d:
  T(N)=O(N^d*logN)
```

问题规模`N`  
子问题规模等量为`N/b`  
调用等量子问题次数`a`  
除去子问题调用剩下的部分时间复杂度`O(N^d)`

### 举例

[RecursiveMax](RecursiveMax.java)  
T(N)=2*T(N/2)+O(1)  
a=2,b=2,d=0  
T(N)=O(N)