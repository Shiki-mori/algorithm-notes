# LeetCode 热题 100

按题号组织，每题一个子包，三件套：`Problem.md`（题目描述）、`Solution.md`（题解）、Java 类（代码）。

与 `leetcode` 包中的题目互不影响：即使题号相同，也在本包单独保留一份骨架。

## 命名约定

| 项 | 规则 | 示例 |
| --- | --- | --- |
| 子包名 | `p` + 四位题号 + `_` + slug（小写+下划线） | `p0001_two_sum` |
| 包声明 | `com.phrolova.algorithm.hot100.<子包名>` | `...hot100.p0001_two_sum` |
| 题目描述 | 固定为 `Problem.md` | — |
| 题解 | 固定为 `Solution.md` | — |
| 代码类 | PascalCase，与题名对应 | `TwoSum.java` |

公共类型见 [`common/`](common/)（`ListNode`、`TreeNode`、`Node`）。

## 索引

| 题号 | 题名 | 目录 |
| --- | --- | --- |
| 1 | Two Sum | [p0001_two_sum](p0001_two_sum/) |
| 2 | Add Two Numbers | [p0002_add_two_numbers](p0002_add_two_numbers/) |
| 3 | Longest Substring Without Repeating Characters | [p0003_longest_substring_without_repeating_characters](p0003_longest_substring_without_repeating_characters/) |
| 4 | Median of Two Sorted Arrays | [p0004_median_of_two_sorted_arrays](p0004_median_of_two_sorted_arrays/) |
| 5 | Longest Palindromic Substring | [p0005_longest_palindromic_substring](p0005_longest_palindromic_substring/) |
| 11 | Container With Most Water | [p0011_container_with_most_water](p0011_container_with_most_water/) |
| 15 | 3Sum | [p0015_3sum](p0015_3sum/) |
| 17 | Letter Combinations of a Phone Number | [p0017_letter_combinations_of_a_phone_number](p0017_letter_combinations_of_a_phone_number/) |
| 19 | Remove Nth Node From End of List | [p0019_remove_nth_node_from_end_of_list](p0019_remove_nth_node_from_end_of_list/) |
| 20 | Valid Parentheses | [p0020_valid_parentheses](p0020_valid_parentheses/) |
| 21 | Merge Two Sorted Lists | [p0021_merge_two_sorted_lists](p0021_merge_two_sorted_lists/) |
| 22 | Generate Parentheses | [p0022_generate_parentheses](p0022_generate_parentheses/) |
| 23 | Merge k Sorted Lists | [p0023_merge_k_sorted_lists](p0023_merge_k_sorted_lists/) |
| 24 | Swap Nodes in Pairs | [p0024_swap_nodes_in_pairs](p0024_swap_nodes_in_pairs/) |
| 25 | Reverse Nodes in k-Group | [p0025_reverse_nodes_in_k_group](p0025_reverse_nodes_in_k_group/) |
| 31 | Next Permutation | [p0031_next_permutation](p0031_next_permutation/) |
| 32 | Longest Valid Parentheses | [p0032_longest_valid_parentheses](p0032_longest_valid_parentheses/) |
| 33 | Search in Rotated Sorted Array | [p0033_search_in_rotated_sorted_array](p0033_search_in_rotated_sorted_array/) |
| 34 | Find First and Last Position of Element in Sorted Array | [p0034_find_first_and_last_position_of_element_in_sorted_array](p0034_find_first_and_last_position_of_element_in_sorted_array/) |
| 35 | Search Insert Position | [p0035_search_insert_position](p0035_search_insert_position/) |
| 39 | Combination Sum | [p0039_combination_sum](p0039_combination_sum/) |
| 41 | First Missing Positive | [p0041_first_missing_positive](p0041_first_missing_positive/) |
| 42 | Trapping Rain Water | [p0042_trapping_rain_water](p0042_trapping_rain_water/) |
| 45 | Jump Game II | [p0045_jump_game_ii](p0045_jump_game_ii/) |
| 46 | Permutations | [p0046_permutations](p0046_permutations/) |
| 48 | Rotate Image | [p0048_rotate_image](p0048_rotate_image/) |
| 49 | Group Anagrams | [p0049_group_anagrams](p0049_group_anagrams/) |
| 51 | N-Queens | [p0051_n_queens](p0051_n_queens/) |
| 53 | Maximum Subarray | [p0053_maximum_subarray](p0053_maximum_subarray/) |
| 54 | Spiral Matrix | [p0054_spiral_matrix](p0054_spiral_matrix/) |
| 55 | Jump Game | [p0055_jump_game](p0055_jump_game/) |
| 56 | Merge Intervals | [p0056_merge_intervals](p0056_merge_intervals/) |
| 62 | Unique Paths | [p0062_unique_paths](p0062_unique_paths/) |
| 64 | Minimum Path Sum | [p0064_minimum_path_sum](p0064_minimum_path_sum/) |
| 70 | Climbing Stairs | [p0070_climbing_stairs](p0070_climbing_stairs/) |
| 72 | Edit Distance | [p0072_edit_distance](p0072_edit_distance/) |
| 73 | Set Matrix Zeroes | [p0073_set_matrix_zeroes](p0073_set_matrix_zeroes/) |
| 74 | Search a 2D Matrix | [p0074_search_a_2d_matrix](p0074_search_a_2d_matrix/) |
| 75 | Sort Colors | [p0075_sort_colors](p0075_sort_colors/) |
| 76 | Minimum Window Substring | [p0076_minimum_window_substring](p0076_minimum_window_substring/) |
| 78 | Subsets | [p0078_subsets](p0078_subsets/) |
| 79 | Word Search | [p0079_word_search](p0079_word_search/) |
| 84 | Largest Rectangle in Histogram | [p0084_largest_rectangle_in_histogram](p0084_largest_rectangle_in_histogram/) |
| 94 | Binary Tree Inorder Traversal | [p0094_binary_tree_inorder_traversal](p0094_binary_tree_inorder_traversal/) |
| 98 | Validate Binary Search Tree | [p0098_validate_binary_search_tree](p0098_validate_binary_search_tree/) |
| 101 | Symmetric Tree | [p0101_symmetric_tree](p0101_symmetric_tree/) |
| 102 | Binary Tree Level Order Traversal | [p0102_binary_tree_level_order_traversal](p0102_binary_tree_level_order_traversal/) |
| 104 | Maximum Depth of Binary Tree | [p0104_maximum_depth_of_binary_tree](p0104_maximum_depth_of_binary_tree/) |
| 105 | Construct Binary Tree from Preorder and Inorder Traversal | [p0105_construct_binary_tree_from_preorder_and_inorder_traversal](p0105_construct_binary_tree_from_preorder_and_inorder_traversal/) |
| 108 | Convert Sorted Array to Binary Search Tree | [p0108_convert_sorted_array_to_binary_search_tree](p0108_convert_sorted_array_to_binary_search_tree/) |
| 114 | Flatten Binary Tree to Linked List | [p0114_flatten_binary_tree_to_linked_list](p0114_flatten_binary_tree_to_linked_list/) |
| 118 | Pascal's Triangle | [p0118_pascals_triangle](p0118_pascals_triangle/) |
| 121 | Best Time to Buy and Sell Stock | [p0121_best_time_to_buy_and_sell_stock](p0121_best_time_to_buy_and_sell_stock/) |
| 124 | Binary Tree Maximum Path Sum | [p0124_binary_tree_maximum_path_sum](p0124_binary_tree_maximum_path_sum/) |
| 128 | Longest Consecutive Sequence | [p0128_longest_consecutive_sequence](p0128_longest_consecutive_sequence/) |
| 131 | Palindrome Partitioning | [p0131_palindrome_partitioning](p0131_palindrome_partitioning/) |
| 136 | Single Number | [p0136_single_number](p0136_single_number/) |
| 138 | Copy List with Random Pointer | [p0138_copy_list_with_random_pointer](p0138_copy_list_with_random_pointer/) |
| 139 | Word Break | [p0139_word_break](p0139_word_break/) |
| 141 | Linked List Cycle | [p0141_linked_list_cycle](p0141_linked_list_cycle/) |
| 142 | Linked List Cycle II | [p0142_linked_list_cycle_ii](p0142_linked_list_cycle_ii/) |
| 146 | LRU Cache | [p0146_lru_cache](p0146_lru_cache/) |
| 148 | Sort List | [p0148_sort_list](p0148_sort_list/) |
| 152 | Maximum Product Subarray | [p0152_maximum_product_subarray](p0152_maximum_product_subarray/) |
| 153 | Find Minimum in Rotated Sorted Array | [p0153_find_minimum_in_rotated_sorted_array](p0153_find_minimum_in_rotated_sorted_array/) |
| 155 | Min Stack | [p0155_min_stack](p0155_min_stack/) |
| 160 | Intersection of Two Linked Lists | [p0160_intersection_of_two_linked_lists](p0160_intersection_of_two_linked_lists/) |
| 169 | Majority Element | [p0169_majority_element](p0169_majority_element/) |
| 189 | Rotate Array | [p0189_rotate_array](p0189_rotate_array/) |
| 198 | House Robber | [p0198_house_robber](p0198_house_robber/) |
| 199 | Binary Tree Right Side View | [p0199_binary_tree_right_side_view](p0199_binary_tree_right_side_view/) |
| 200 | Number of Islands | [p0200_number_of_islands](p0200_number_of_islands/) |
| 206 | Reverse Linked List | [p0206_reverse_linked_list](p0206_reverse_linked_list/) |
| 207 | Course Schedule | [p0207_course_schedule](p0207_course_schedule/) |
| 208 | Implement Trie (Prefix Tree) | [p0208_implement_trie_prefix_tree](p0208_implement_trie_prefix_tree/) |
| 215 | Kth Largest Element in an Array | [p0215_kth_largest_element_in_an_array](p0215_kth_largest_element_in_an_array/) |
| 226 | Invert Binary Tree | [p0226_invert_binary_tree](p0226_invert_binary_tree/) |
| 230 | Kth Smallest Element in a BST | [p0230_kth_smallest_element_in_a_bst](p0230_kth_smallest_element_in_a_bst/) |
| 234 | Palindrome Linked List | [p0234_palindrome_linked_list](p0234_palindrome_linked_list/) |
| 236 | Lowest Common Ancestor of a Binary Tree | [p0236_lowest_common_ancestor_of_a_binary_tree](p0236_lowest_common_ancestor_of_a_binary_tree/) |
| 238 | Product of Array Except Self | [p0238_product_of_array_except_self](p0238_product_of_array_except_self/) |
| 239 | Sliding Window Maximum | [p0239_sliding_window_maximum](p0239_sliding_window_maximum/) |
| 240 | Search a 2D Matrix II | [p0240_search_a_2d_matrix_ii](p0240_search_a_2d_matrix_ii/) |
| 279 | Perfect Squares | [p0279_perfect_squares](p0279_perfect_squares/) |
| 283 | Move Zeroes | [p0283_move_zeroes](p0283_move_zeroes/) |
| 287 | Find the Duplicate Number | [p0287_find_the_duplicate_number](p0287_find_the_duplicate_number/) |
| 295 | Find Median from Data Stream | [p0295_find_median_from_data_stream](p0295_find_median_from_data_stream/) |
| 300 | Longest Increasing Subsequence | [p0300_longest_increasing_subsequence](p0300_longest_increasing_subsequence/) |
| 322 | Coin Change | [p0322_coin_change](p0322_coin_change/) |
| 347 | Top K Frequent Elements | [p0347_top_k_frequent_elements](p0347_top_k_frequent_elements/) |
| 394 | Decode String | [p0394_decode_string](p0394_decode_string/) |
| 416 | Partition Equal Subset Sum | [p0416_partition_equal_subset_sum](p0416_partition_equal_subset_sum/) |
| 437 | Path Sum III | [p0437_path_sum_iii](p0437_path_sum_iii/) |
| 438 | Find All Anagrams in a String | [p0438_find_all_anagrams_in_a_string](p0438_find_all_anagrams_in_a_string/) |
| 543 | Diameter of Binary Tree | [p0543_diameter_of_binary_tree](p0543_diameter_of_binary_tree/) |
| 560 | Subarray Sum Equals K | [p0560_subarray_sum_equals_k](p0560_subarray_sum_equals_k/) |
| 739 | Daily Temperatures | [p0739_daily_temperatures](p0739_daily_temperatures/) |
| 763 | Partition Labels | [p0763_partition_labels](p0763_partition_labels/) |
| 994 | Rotting Oranges | [p0994_rotting_oranges](p0994_rotting_oranges/) |
| 1143 | Longest Common Subsequence | [p1143_longest_common_subsequence](p1143_longest_common_subsequence/) |

## 热题 100

学习计划：[top-100-liked](https://leetcode.cn/studyplan/top-100-liked/)

### 哈希

- [1. Two Sum](p0001_two_sum/)
- [49. Group Anagrams](p0049_group_anagrams/)
- [128. Longest Consecutive Sequence](p0128_longest_consecutive_sequence/)

### 双指针

- [283. Move Zeroes](p0283_move_zeroes/)
- [11. Container With Most Water](p0011_container_with_most_water/)
- [15. 3Sum](p0015_3sum/)
- [42. Trapping Rain Water](p0042_trapping_rain_water/)

### 滑动窗口

- [3. Longest Substring Without Repeating Characters](p0003_longest_substring_without_repeating_characters/)
- [438. Find All Anagrams in a String](p0438_find_all_anagrams_in_a_string/)

### 子串

- [560. Subarray Sum Equals K](p0560_subarray_sum_equals_k/)
- [239. Sliding Window Maximum](p0239_sliding_window_maximum/)
- [76. Minimum Window Substring](p0076_minimum_window_substring/)

### 普通数组

- [53. Maximum Subarray](p0053_maximum_subarray/)
- [56. Merge Intervals](p0056_merge_intervals/)
- [189. Rotate Array](p0189_rotate_array/)
- [238. Product of Array Except Self](p0238_product_of_array_except_self/)
- [41. First Missing Positive](p0041_first_missing_positive/)

### 矩阵

- [73. Set Matrix Zeroes](p0073_set_matrix_zeroes/)
- [54. Spiral Matrix](p0054_spiral_matrix/)
- [48. Rotate Image](p0048_rotate_image/)
- [240. Search a 2D Matrix II](p0240_search_a_2d_matrix_ii/)

### 链表

- [160. Intersection of Two Linked Lists](p0160_intersection_of_two_linked_lists/)
- [206. Reverse Linked List](p0206_reverse_linked_list/)
- [234. Palindrome Linked List](p0234_palindrome_linked_list/)
- [141. Linked List Cycle](p0141_linked_list_cycle/)
- [142. Linked List Cycle II](p0142_linked_list_cycle_ii/)
- [21. Merge Two Sorted Lists](p0021_merge_two_sorted_lists/)
- [2. Add Two Numbers](p0002_add_two_numbers/)
- [19. Remove Nth Node From End of List](p0019_remove_nth_node_from_end_of_list/)
- [24. Swap Nodes in Pairs](p0024_swap_nodes_in_pairs/)
- [25. Reverse Nodes in k-Group](p0025_reverse_nodes_in_k_group/)
- [138. Copy List with Random Pointer](p0138_copy_list_with_random_pointer/)
- [148. Sort List](p0148_sort_list/)
- [23. Merge k Sorted Lists](p0023_merge_k_sorted_lists/)
- [146. LRU Cache](p0146_lru_cache/)

### 二叉树

- [94. Binary Tree Inorder Traversal](p0094_binary_tree_inorder_traversal/)
- [104. Maximum Depth of Binary Tree](p0104_maximum_depth_of_binary_tree/)
- [226. Invert Binary Tree](p0226_invert_binary_tree/)
- [101. Symmetric Tree](p0101_symmetric_tree/)
- [543. Diameter of Binary Tree](p0543_diameter_of_binary_tree/)
- [102. Binary Tree Level Order Traversal](p0102_binary_tree_level_order_traversal/)
- [108. Convert Sorted Array to Binary Search Tree](p0108_convert_sorted_array_to_binary_search_tree/)
- [98. Validate Binary Search Tree](p0098_validate_binary_search_tree/)
- [230. Kth Smallest Element in a BST](p0230_kth_smallest_element_in_a_bst/)
- [199. Binary Tree Right Side View](p0199_binary_tree_right_side_view/)
- [114. Flatten Binary Tree to Linked List](p0114_flatten_binary_tree_to_linked_list/)
- [105. Construct Binary Tree from Preorder and Inorder Traversal](p0105_construct_binary_tree_from_preorder_and_inorder_traversal/)
- [437. Path Sum III](p0437_path_sum_iii/)
- [236. Lowest Common Ancestor of a Binary Tree](p0236_lowest_common_ancestor_of_a_binary_tree/)
- [124. Binary Tree Maximum Path Sum](p0124_binary_tree_maximum_path_sum/)

### 图论

- [200. Number of Islands](p0200_number_of_islands/)
- [994. Rotting Oranges](p0994_rotting_oranges/)
- [207. Course Schedule](p0207_course_schedule/)
- [208. Implement Trie (Prefix Tree)](p0208_implement_trie_prefix_tree/)

### 回溯

- [46. Permutations](p0046_permutations/)
- [78. Subsets](p0078_subsets/)
- [17. Letter Combinations of a Phone Number](p0017_letter_combinations_of_a_phone_number/)
- [39. Combination Sum](p0039_combination_sum/)
- [22. Generate Parentheses](p0022_generate_parentheses/)
- [79. Word Search](p0079_word_search/)
- [131. Palindrome Partitioning](p0131_palindrome_partitioning/)
- [51. N-Queens](p0051_n_queens/)

### 二分查找

- [35. Search Insert Position](p0035_search_insert_position/)
- [74. Search a 2D Matrix](p0074_search_a_2d_matrix/)
- [34. Find First and Last Position of Element in Sorted Array](p0034_find_first_and_last_position_of_element_in_sorted_array/)
- [33. Search in Rotated Sorted Array](p0033_search_in_rotated_sorted_array/)
- [153. Find Minimum in Rotated Sorted Array](p0153_find_minimum_in_rotated_sorted_array/)
- [4. Median of Two Sorted Arrays](p0004_median_of_two_sorted_arrays/)

### 栈

- [20. Valid Parentheses](p0020_valid_parentheses/)
- [155. Min Stack](p0155_min_stack/)
- [394. Decode String](p0394_decode_string/)
- [739. Daily Temperatures](p0739_daily_temperatures/)
- [84. Largest Rectangle in Histogram](p0084_largest_rectangle_in_histogram/)

### 堆

- [215. Kth Largest Element in an Array](p0215_kth_largest_element_in_an_array/)
- [347. Top K Frequent Elements](p0347_top_k_frequent_elements/)
- [295. Find Median from Data Stream](p0295_find_median_from_data_stream/)

### 贪心算法

- [121. Best Time to Buy and Sell Stock](p0121_best_time_to_buy_and_sell_stock/)
- [55. Jump Game](p0055_jump_game/)
- [45. Jump Game II](p0045_jump_game_ii/)
- [763. Partition Labels](p0763_partition_labels/)

### 动态规划

- [70. Climbing Stairs](p0070_climbing_stairs/)
- [118. Pascal's Triangle](p0118_pascals_triangle/)
- [198. House Robber](p0198_house_robber/)
- [279. Perfect Squares](p0279_perfect_squares/)
- [322. Coin Change](p0322_coin_change/)
- [139. Word Break](p0139_word_break/)
- [300. Longest Increasing Subsequence](p0300_longest_increasing_subsequence/)
- [152. Maximum Product Subarray](p0152_maximum_product_subarray/)
- [416. Partition Equal Subset Sum](p0416_partition_equal_subset_sum/)
- [32. Longest Valid Parentheses](p0032_longest_valid_parentheses/)

### 多维动态规划

- [62. Unique Paths](p0062_unique_paths/)
- [64. Minimum Path Sum](p0064_minimum_path_sum/)
- [5. Longest Palindromic Substring](p0005_longest_palindromic_substring/)
- [1143. Longest Common Subsequence](p1143_longest_common_subsequence/)
- [72. Edit Distance](p0072_edit_distance/)

### 技巧

- [136. Single Number](p0136_single_number/)
- [169. Majority Element](p0169_majority_element/)
- [75. Sort Colors](p0075_sort_colors/)
- [31. Next Permutation](p0031_next_permutation/)
- [287. Find the Duplicate Number](p0287_find_the_duplicate_number/)
