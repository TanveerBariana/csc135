(define (isEven x) (equal? (modulo x 2) 0))
(define (isOdd x) (not (isEven x)))
(define (isNeg c) (< c 0 ))
(define (negate x) (- 0 x ))
(define (square x) (* x x))
(define (cube x) (* x (* x x )))

;I also use the library methods of length, remove, quotient, modulo, list? and list-ref
;--function A-----all methods used for this are in this section------------------------------------------------------------------------------------------------
(define (length_fctn x count) (if (= x 0) count ;this is meant to give me the length of an integer string like 123 or 53454
                                  (length_fctn (quotient x 10) (+ count 1))))

(define (length_mine x) (length_fctn x 0)) ;I originally intended to make this usable for each problem so it takes one input 

(define (buildLR x y) (if (or (< (length_mine x) 2) (< (length_mine y) 2)) -1
                          (if (> (abs x) 100) (buildLR (quotient(abs x) 10) (abs y))
                           (+ (* 100 (abs x)) (modulo (abs y) 100)))))
;--function b-----all methods used for this are in this section-----------------------------------------------------------------------------------------
(define (listMins x y) (if (null? x) '()
                           (if (< (car x) (car y))(cons (car x) (listMins (cdr x) (cdr y)))
                               (cons (car y) (listMins (cdr x) (cdr y))))))
;--function c-----all methods used for this are in this section-------------------------------------------------------------------------------------------
(define (unwind x) (if (null? x) '() 
                      (if (isEven (length x)) (cons (list-ref x (- (quotient (length x) 2) 1))(unwind (remove(list-ref x(- (quotient(length x) 2) 1))x)))
                                                     (cons (list-ref x (quotient (length x) 2)) (unwind (remove(list-ref x(quotient(length x) 2)) x))))))
;--function d------this makes use of the boolean expressions before function a as well as the below code--------------------------------------------------------------------------------------------
(define (functionWinner F G L) (functionW_back F G L 0 0)); function that takes in right input

(define (functionW_back first next list count1 count2) (if (null? list) (if (= count1 count2) 0 ;function that actually sees who wins
                                                                            (if (> count1 count2) 1
                                                                            2))
                                                           (if (first (car list)) (if (next (car list)) (functionW_back first next (cdr list) (+ count1 1) (+ count2 1)); if the elemet satisfies both tests
                                                                                     (functionW_back first next (cdr list) (+ count1 1) count2)); if it satisfies the first but not second test
                                                               (if (next (car list)) (functionW_back first next (cdr list) count1 (+ count2 1)); if it satisfies only the second test
                                                                   (functionW_back first next (cdr list) count1 count2))))); if it satisfies neither test 
  ;--function e---all methods used are in this section --------------------------------------------------------------------------------------------------------------------------------------                                                        
 (define (getNestedCount x) (getN_listcount x 0));take in correct input 

 (define (getN_listcount x y )(if (null? x) y ; return how many elements were in the list before it was empty 
                               (if (list? (car x)) ; check to see if first element is a list 
								(if (not(null? (cdr x))); then inspect if there are elements behind the list
									(getN_listcount (cdr x) (+ 0 y)); if they exist do them  
                                    (+ (getN_listcount(car x) y) y)); else dive in to see how many elements are in the nested list
                                   (getN_listcount (cdr x) (+ 1 y))))); is the first element is not a list increment it and advance one
 ;--function f----all methods used are in this section-------------------------------------------------------------------------------------------------------------  
 (define (makeCutter N) ; make a method that takes in correct input 
   (lambda (N) (Cutter N x)))

 (define (Cutter N x) (if (= N 0) '() ;continue as long as N lets you
                          (if (< (length x) N) x
                              (cons (car x) (Cutter (- N 1) (cdr x)))))) ; as long as N lets you, add items to the list being shown
 