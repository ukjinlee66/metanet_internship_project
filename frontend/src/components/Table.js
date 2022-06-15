import {
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableFooter,
    TableHead,
    TablePagination,
    TableRow,
    Paper
} from "@material-ui/core";
import React, { useState, useEffect } from "react";
import axios from "axios";



function Table1() {

    const reqUrl = 'http://localhost:4000/posts'

    const [users, setUsers] = useState([
        { id: '', name: '', email: '', phone: '' }
    ])
    
    const getListItem = async () => {
        await axios
            .get(reqUrl)
            .then((res) => {setUsers(res.data)
                console.log(res.data)}
            );
            
    }

    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(10);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };

    useEffect(() => {
        getListItem(page);
    }, [])
    return (

        <TableContainer component={Paper}>
            <Table size="small">
                <TableHead>
                    <TableRow>
                        <TableCell>No</TableCell>
                        <TableCell align="right">종류</TableCell>
                        <TableCell align="right">금액</TableCell>
                        <TableCell align="right">날짜</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {users
                        .slice(page * rowsPerPage, (page + 1) * rowsPerPage)
                        .map(({ id, name, email, phone }, i) => (
                            <TableRow key={id}>
                                <TableCell component="th" scope="row">
                                    {page * rowsPerPage + i + 1}
                                </TableCell>
                                <TableCell align="right">{name}</TableCell>
                                <TableCell align="right">{email}</TableCell>
                                <TableCell align="right">{phone}</TableCell>
                            </TableRow>
                        ))}
                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TablePagination
                            count={users.length}
                            page={page}
                            rowsPerPage={rowsPerPage}
                            onChangePage={handleChangePage}
                            onChangeRowsPerPage={handleChangeRowsPerPage}
                        />
                    </TableRow>
                </TableFooter>
            </Table>
        </TableContainer>
    );
}

export default Table1;
